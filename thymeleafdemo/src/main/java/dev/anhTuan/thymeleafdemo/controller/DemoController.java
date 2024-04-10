package dev.anhTuan.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Controller
public class DemoController {
    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model theModel){

        theModel.addAttribute("theDate", LocalDate.now());
        return "helloworld";
    }
}
