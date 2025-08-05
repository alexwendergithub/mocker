package com.projects.mocker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mocker")
public class MockerMainController {
    @GetMapping("/{url}")
    public String GetUrlMapping() {
        System.out.println("test");
        return "test";
    }

    @PostMapping("/{url}")
    public String CreateUrlMapping(){
        System.out.println("test2");
        return "test2";
    }

    @PutMapping("/{url}")
    public String EditMapping(){
        System.out.println("test3");
        return "test3";
    }

    @DeleteMapping("/{url}")
    public String DeleteMapping(){
        System.out.println("test4");
        return "test4";
    }
}