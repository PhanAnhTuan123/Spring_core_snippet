package dev.anhTuan.demo.Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello World!";
    }
}
