package dev.anhTuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/myLoan")
    public String getAccountDetail(){
        return "Here are loan details form the DB";
    }
}
