package dev.anhTuan.demo.Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping(path = "/")
    public String showHome(){
        return "home";
    }
}
