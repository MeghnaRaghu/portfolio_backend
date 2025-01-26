package com.example.portfolio.Service;

import com.example.portfolio.Model.Project;
import com.example.portfolio.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();  // Call the method on the injected instance
    }

    // Get project by ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);  // Call the method on the injected instance
    }

    // Save or update a project
    public Project saveOrUpdateProject(Project project) {
        return projectRepository.save(project);  // Call the method on the injected instance
    }

    // Delete project by ID
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);  // Call the method on the injected instance
    }

    // Check if project exists by ID (added method)
    public boolean existsById(Long id) {
        return !projectRepository.existsById(id);  // Call the method on the injected instance
    }
}
