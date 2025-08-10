package com.projects.mocker.controller;

import com.projects.mocker.model.MockEntity;
import com.projects.mocker.service.MockEntityService;
import com.projects.mocker.service.MockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/{mockName}")
@AllArgsConstructor
public class MockController {
    private MockService mockService;
    private MockEntityService mockEntityService;

    @GetMapping("/")
    public ResponseEntity<String> getMockType(@PathVariable String mockName) {
        Optional<MockEntity> mockEntity = mockEntityService.findById(mockName);
        return mockEntity.map(entity -> ResponseEntity.ok().body(entity.getDataInfo()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{mockId}")
    public ResponseEntity<String> getMock(@PathVariable String mockName, @PathVariable String mockId) {
        String result = mockService.getMockById(mockId, mockName);

        if (result == null || result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<String> addMock(@PathVariable String mockName,
                                          @RequestBody String json){
        String result = mockService.save(json,mockName);
        if (result == null || result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{mockId}")
    public ResponseEntity<String> editMock(@PathVariable String mockName,
                           @PathVariable String mockId,
                           @RequestBody String json){

        String result = mockService.edit(mockId,mockName,json);
        if (result == null || result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{mockId}")
    public ResponseEntity<String> deleteMock(@PathVariable String mockName, @PathVariable String mockId){
        String result = mockService.delete(mockId,mockName);
        if (result == null || result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
