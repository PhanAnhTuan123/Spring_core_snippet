package dev.anhTuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    @GetMapping("/myNotices")
    public String getAccountDetail(){
        return "Here are notices details form the DB";
    }
}
