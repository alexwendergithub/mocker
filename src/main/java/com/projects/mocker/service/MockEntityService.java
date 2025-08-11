package com.projects.mocker.service;

import com.projects.mocker.model.MockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projects.mocker.repository.MockEntityRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MockEntityService {
    private final MockEntityRepository mockEntityRepository;
    private final MockService mockService;

    public Optional<MockEntity> findById(String mockId) {
        return mockEntityRepository.findById(mockId);
    }

    public List<MockEntity> findAll() {
        return mockEntityRepository.findAll();
    }

    public String save(MockEntity mockEntity) {
        if (mockEntityRepository.existsById(mockEntity.getId())) {
            return "Id already in use";
        }
        mockService.addFakeData(mockEntity.getQuantity(),mockEntity.getId(), mockEntity.getDataInfo());
        mockEntityRepository.save(mockEntity);
        return "Saved mock successfully";
    }

    public String delete(String mockId){
        if (!mockEntityRepository.existsById(mockId)) {
            return "No mock created with " + mockId + " id";
        }
        mockEntityRepository.deleteById(mockId);
        return "Deleted mock successfully";
    }
}