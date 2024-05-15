package dev.anhTuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/myCards")
    public String getAccountDetail(){
        return "Here are cards details form the DB";
    }
}
