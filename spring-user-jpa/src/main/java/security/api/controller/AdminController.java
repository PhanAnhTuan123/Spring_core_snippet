package security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import security.api.model.User;
import security.api.repository.UserRepository;

@RestController
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/admin/add")
    public String addUserByAdmin(@RequestBody User user){
        userRepository.save(user);
        return "user added successfully..";
    }
}
