package dev.anhTuan.springConfigFileV2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/")
public class HelloWorldController {
    @GetMapping(path = "/hello")
    public String hello(){
        return "hello World!";
    }

}
