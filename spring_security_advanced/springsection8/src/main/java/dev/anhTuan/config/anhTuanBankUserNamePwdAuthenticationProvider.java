package dev.anhTuan.config;

import dev.anhTuan.model.Authority;
import dev.anhTuan.model.Customer;
import dev.anhTuan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class anhTuanBankUserNamePwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String pwd = authentication.getCredentials().toString();
        System.out.println(pwd);
        List<Customer> customers= customerRepository.findByEmail(username);
        if(customers.size() > 0){
            if(passwordEncoder.matches(pwd,customers.get(0).getPwd())){
//                List<GrantedAuthority>authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username,pwd,getGrantedAuthorities(customers.get(0).getAuthorities()));
            }else{
                throw new BadCredentialsException("Invalid password");
            }
        }else{
            throw new BadCredentialsException("No user registered with this details");
        }
    }

    private List<GrantedAuthority>getGrantedAuthorities(Set<Authority> authorities){
        List<GrantedAuthority>grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities){
            grantedAuthorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return authority.getName();
                }
            });
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
