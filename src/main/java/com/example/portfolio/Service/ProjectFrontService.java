package com.example.portfolio.Service;

import com.example.portfolio.Model.ProjectFront;
import com.example.portfolio.Repository.ProjectFrontRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectFrontService {

    @Autowired
    private ProjectFrontRepository projectFrontRepository;

    // Get all projects
    public List<ProjectFront> getAllProjects() {
        return projectFrontRepository.findAll();
    }

    // Get a single project by UUID
    public Optional<ProjectFront> getProjectById(UUID id) {
        return projectFrontRepository.findById(id);
    }

    // Add a new project
    public ProjectFront addProject(ProjectFront projectFront) {
        return projectFrontRepository.save(projectFront);
    }

    // Update a project by UUID
    public ProjectFront updateProject(UUID id, ProjectFront projectFront) {
        if (projectFrontRepository.existsById(id)) {
            projectFront.setId(id);
            return projectFrontRepository.save(projectFront);
        }
        return null; // Return null if not found
    }

    // Delete a project by UUID
    public void deleteProject(UUID id) {
        projectFrontRepository.deleteById(id);
    }
}
