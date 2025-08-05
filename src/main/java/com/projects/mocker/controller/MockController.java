package com.projects.mocker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{mockName}")
public class MockController {

    @GetMapping("/")
    public String GetMockType() {
        System.out.println("expected type");
        return "expected type";
    }

    @GetMapping("/{mock}")
    public String GetMock() {
        System.out.println("test");
        return "test";
    }

    @PostMapping("/{mock}")
    public String AddMock(){
        System.out.println("test2");
        return "test2";
    }

    @PutMapping("/{mock}")
    public String EditMock(){
        System.out.println("test3");
        return "test3";
    }

    @DeleteMapping("/{mock}")
    public String DeleteMock(){
        System.out.println("test4");
        return "test4";
    }
}
