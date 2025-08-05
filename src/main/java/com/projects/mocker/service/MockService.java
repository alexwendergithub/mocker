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

    public MockEntity save(MockEntity mockEntity) {
        return mockRepository.save(mockEntity);
    }
}