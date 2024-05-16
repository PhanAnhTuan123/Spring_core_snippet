package dev.anhTuan.controller;

import dev.anhTuan.model.Accounts;
import dev.anhTuan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/myAccount")
    public Accounts getAccountDetais(@RequestParam int id){
        Accounts accounts = accountRepository.findByCustomerId(id);
        if(accounts!=null){
            return accounts;
        }else{
            return null;
        }

    }
}
