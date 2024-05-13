package com.shopme.springsecurity_demo.config;

import com.shopme.springsecurity_demo.entities.Privilege;
import com.shopme.springsecurity_demo.entities.Role;
import com.shopme.springsecurity_demo.entities.User;
import com.shopme.springsecurity_demo.repositories.PrivilegeRepository;
import com.shopme.springsecurity_demo.repositories.RoleRepository;
import com.shopme.springsecurity_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup){
            return;
        }
        Privilege readPrivilege = creaPrivilegeIfnotFound("READ_PRIVILEGE");
        Privilege writePrivilege = creaPrivilegeIfnotFound("WRITE_PRIVILEGE");
        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege,writePrivilege
        );
        createRoleIfnotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfnotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);
        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfnotFound(String name, Collection<Privilege>privileges){
        Role role = roleRepository.findByName(name);
        if(role==null){
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
    @Transactional
    Privilege creaPrivilegeIfnotFound(String name){
        Privilege privilege = privilegeRepository.findByName(name);
        if(privilege == null){
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }
}
