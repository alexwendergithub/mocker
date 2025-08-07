package com.projects.mocker.service;

import com.projects.mocker.model.MockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projects.mocker.repository.MockRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MockService {
    private final MockRepository mockRepository;

    public Optional<MockEntity> findById(String mockId) {
        return mockRepository.findById(mockId);
    }

    public List<MockEntity> findAll() {
        return mockRepository.findAll();
    }

    public String save(MockEntity mockEntity) {
        if (mockRepository.existsById(mockEntity.getId())) {
            return "Id already in use";
        }

        mockRepository.save(mockEntity);
        return "Saved mock successfully";
    }

    public String delete(String mockId){
        if (!mockRepository.existsById(mockId)) {
            return "No mock created with " + mockId + " id";
        }

        mockRepository.deleteById(mockId);
        return "Deleted mock successfully";
    }
}