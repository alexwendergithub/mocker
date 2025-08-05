package com.projects.mocker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mocker")
public class MockerMainController {
    @GetMapping("/{url}")
    public String CreateUrlMapping() {
        System.out.println("test");
        return "test";
    }

}