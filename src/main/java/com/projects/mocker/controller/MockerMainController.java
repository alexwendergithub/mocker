package com.projects.mocker.controller;

import com.projects.mocker.model.MockEntity;
import com.projects.mocker.service.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mocker")
@RequiredArgsConstructor
public class MockerMainController {
    private final MockService mockService;

    @GetMapping("/")
    public ResponseEntity<List<MockEntity>> findAllMocks() {
        return ResponseEntity.ok().body(mockService.findAll());
    }

    @GetMapping("/{mockId}")
    public ResponseEntity<MockEntity> getUserById(@PathVariable String mockId) {
        return mockService.findById(mockId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{mockId}")
    public ResponseEntity<String> insert(@RequestBody MockEntity mockDto) {
        var result = mockService.save(mockDto);
        //{ADICIONAR FAKE DATA DO MOCK AQUI}
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @PutMapping("/{mockId}")
    public String editMapping(){
        System.out.println("test3");
        //{REMAKE FAKE DATA DO MOCK IF NECESSARY}
        return "test3";
    }

    @DeleteMapping("/{mockId}")
    public ResponseEntity<String> deleteMapping(@PathVariable String mockId){
        var result = mockService.delete(mockId);
        //{DELETE FAKE DATA DO MOCK AS WELL}
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}