package com.projects.mocker.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.projects.mocker.model.MockEntity;
import com.projects.mocker.service.MockEntityService;
import com.projects.mocker.service.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/mocker")
@RequiredArgsConstructor
public class MockEntityController {
    private final MockEntityService mockEntityService;
    private final MockService mockService;

    @GetMapping("/")
    public ResponseEntity<List<MockEntity>> findAllMocks() {
        return ResponseEntity.ok().body(mockEntityService.findAll());
    }

    @GetMapping("/{mockId}")
    public ResponseEntity<MockEntity> getUserById(@PathVariable String mockId) {
        return mockEntityService.findById(mockId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<String> insert(@RequestBody MockEntity mockDto) {
        var result = mockEntityService.save(mockDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @DeleteMapping("/{mockId}")
    public ResponseEntity<String> deleteMapping(@PathVariable String mockId){
        var result = mockEntityService.delete(mockId);
        mockService.deleteCollection(mockId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

}