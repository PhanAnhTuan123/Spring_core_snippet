package com.shopme.springsecurity_demo.config;

import com.shopme.springsecurity_demo.entities.Privilege;
import com.shopme.springsecurity_demo.entities.Role;
import com.shopme.springsecurity_demo.entities.User;
import com.shopme.springsecurity_demo.repositories.RoleRepository;
import com.shopme.springsecurity_demo.repositories.UserRepository;
import com.shopme.springsecurity_demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService service;
    @Autowired
    private MessageSource message;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user == null){
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleRepository.findByName("ROLE_USER"))));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority>getAuthorities(Collection<Role>roles){
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
            List<GrantedAuthority>authorities = new ArrayList<>();
            for(String privilege : privileges){
                authorities.add(new SimpleGrantedAuthority(privilege));
            }
            return  authorities;
    }

    private List<String>getPrivileges(Collection<Role>roles){
        List<String>privileges = new ArrayList<>();
        List<Privilege>collection = new ArrayList<>();
        for (Role role : roles){
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection){
            privileges.add(item.getName());
        }
        return privileges;
    }

}
