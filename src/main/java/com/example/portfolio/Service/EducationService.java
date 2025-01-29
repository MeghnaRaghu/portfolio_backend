package com.example.portfolio.Service;

import com.example.portfolio.Model.Education;
import com.example.portfolio.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    // Get all education records
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    // Add a new education record
    public Education addEducation(Education education) {
        return educationRepository.save(education);
    }

    // Get education record by ID (UUID)
    public Optional<Education> getEducationById(UUID id) {
        return educationRepository.findById(id);
    }

    // Delete education record by ID (UUID)
    public void deleteEducation(UUID id) {
        educationRepository.deleteById(id);
    }
}
