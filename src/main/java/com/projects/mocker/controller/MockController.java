package com.projects.mocker.controller;

import com.projects.mocker.service.MockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{mockName}")
@AllArgsConstructor
public class MockController {
    private MockService mockService;

    @GetMapping("/")
    public String getMockType() {
        System.out.println("expected type");
        return "expected type";
    }

    @GetMapping("/{mock}")
    public String getMock() {
        System.out.println("test");
        return "test";
    }

    @PostMapping("/{mock}")
    public String addMock(){
        System.out.println("test2");
        return "test2";
    }

    @PutMapping("/{mock}")
    public String editMock(){
        System.out.println("test3");
        return "test3";
    }

    @DeleteMapping("/{mock}")
    public String deleteMock(){
        System.out.println("test4");
        return "test4";
    }
}
