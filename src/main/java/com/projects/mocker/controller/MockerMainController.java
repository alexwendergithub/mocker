package com.projects.mocker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mocker")
public class MockerMainController {
    @GetMapping("/{url}")
    public String getUrlMapping() {
        System.out.println("test");
        return "test";
    }

    @PostMapping("/{url}")
    public String createUrlMapping(){
        System.out.println("test2");
        return "test2";
    }

    @PutMapping("/{url}")
    public String editMapping(){
        System.out.println("test3");
        return "test3";
    }

    @DeleteMapping("/{url}")
    public String deleteMapping(){
        System.out.println("test4");
        return "test4";
    }
}