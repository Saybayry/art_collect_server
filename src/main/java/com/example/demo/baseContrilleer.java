package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class baseContrilleer {

    @GetMapping("/test")
    public String Greetings(){
        return "eroor";
    }

}
