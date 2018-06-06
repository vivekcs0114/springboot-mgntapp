package com.synerzip.college.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {

    @RequestMapping("/")
    public String sayHello() {
        return "hello";
    }

}
