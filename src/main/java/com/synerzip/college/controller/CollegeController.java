package com.synerzip.college.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {

    private static final Logger log = LoggerFactory.getLogger(CollegeController.class);

    @RequestMapping("/")
    public String sayHello() {
        log.info("sayHello method invoked from collegeController");
        return "hello";
    }

}
