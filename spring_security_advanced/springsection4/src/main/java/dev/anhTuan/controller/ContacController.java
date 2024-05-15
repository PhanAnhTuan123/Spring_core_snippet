package dev.anhTuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContacController {

    @GetMapping("/contact")
    public String getAccountDetail(){
        return "Inquiry details are saved to the DB";
    }
}
