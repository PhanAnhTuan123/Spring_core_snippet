package com.anhTuan.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/first_controller")
public class StartingController {
    @GetMapping
    public ResponseEntity<String>sayHello(){
        return ResponseEntity.ok("Hello fro sucured endpoint.");
    }
}
