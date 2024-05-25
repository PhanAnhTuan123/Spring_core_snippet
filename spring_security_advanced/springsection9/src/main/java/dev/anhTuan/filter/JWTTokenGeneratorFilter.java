package dev.anhTuan.filter;

import dev.anhTuan.contants.SecurityContants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecretKey key = Keys.hmacShaKeyFor(SecurityContants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder().setIssuer("anhTuan Bank").setSubject("JWT Token")
                .claim("username",authentication.getPrincipal().toString())
                .claim("authorities",populateAuthorities(authentication.getAuthorities()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() + 30000000)))
                .signWith(key).compact();
        response.setHeader(SecurityContants.JWT_HEADER,jwt);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user");
    }
    private String populateAuthorities(Collection<? extends GrantedAuthority> collections){
        Set<String>authoritySet = new HashSet<>();
        for (GrantedAuthority authority : collections){
            authoritySet.add(authority.getAuthority());
        }
            return String.join(",",authoritySet);

    }
}
