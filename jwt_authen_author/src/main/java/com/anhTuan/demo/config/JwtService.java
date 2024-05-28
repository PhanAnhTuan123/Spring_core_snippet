package com.anhTuan.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "fGLU9vYr74A5YDO+oIRj5xszxrGAR1F2siPl/qUJsd4gWlnUctcVzhXYhM0fsvl2pb+3lSCXE0YkvL7Vt44uBpDw2QzmywKt/gqcApdB/5InKtmdxNEOCsJ4oR0LGYbwEuFvynLS0SOj1ZAxobMrd4ZZ/VkyWxB3SqSBeU+uzhZsTG582/8FzqgU+yWwHDFt/XKmY9kn0cjY6L6ErYN6U4E1x7uqiPSMEW72i1EsQSo8tfGLHeCKQrsJA7nivlCsgZe8CcCjdiq0N4OyWZO4lhhJIXkoxnt0vc/ML096XNvyCw7IHKt3ie9R8YOQmsKb5kWXpZS/eUNkYyD2uZDjDiGj62R/dLH7rlvZuZNmEDw=\n";

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsRsolver){
        final Claims claims = extractAllClaims(token);
        return claimsRsolver.apply(claims);
    }
    public String generateToken(
            Map<String,Object>extraClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSignInKey() , SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
