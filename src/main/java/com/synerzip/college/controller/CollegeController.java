package com.synerzip.college.controller;

import com.synerzip.college.exception.CarNotFoundException;
import com.synerzip.college.model.Car;

import com.synerzip.college.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollegeController {

    CarService service;

    public CollegeController(CarService service) {
        this.service = service;
    }

    @GetMapping("/colleges/{name}")
    public Car sayHello(@PathVariable String name) {
        return service.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {

    }

    @GetMapping("/all")
    public String hello() {
        return "Hello World!!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello world!!";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "Alternate Hello world!!";
    }

}
