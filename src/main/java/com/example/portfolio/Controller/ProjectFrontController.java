package com.example.portfolio.Controller;

import com.example.portfolio.Model.ProjectFront;
import com.example.portfolio.Service.ProjectFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/projectfront")
public class ProjectFrontController {

    @Autowired
    private ProjectFrontService projectFrontService;

    // Get all projects
    @GetMapping
    public List<ProjectFront> getAllProjects() {
        return projectFrontService.getAllProjects();
    }

    // Get a project by id
    @GetMapping("/{id}")
    public ResponseEntity<ProjectFront> getProjectById(@PathVariable UUID id) {
        Optional<ProjectFront> project = projectFrontService.getProjectById(id);
        return project.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new project
    @PostMapping(consumes = "multipart/form-data")
    public ProjectFront addProject(@RequestParam("name") String name,
                                   @RequestParam("description") String description,
                                   @RequestParam("image") MultipartFile image,
                                   @RequestParam("details") String details,         // New parameter
                                   @RequestParam("technologies") String technologies, // New parameter
                                   @RequestParam("duration") String duration) throws IOException {  // New parameter

        ProjectFront projectFront = new ProjectFront();
        projectFront.setName(name);
        projectFront.setDescription(description);
        projectFront.setImage(image.getBytes()); // Store the image as binary data
        projectFront.setDetails(details);          // Set details
        projectFront.setTechnologies(technologies); // Set technologies
        projectFront.setDuration(duration);        // Set duration

        return projectFrontService.addProject(projectFront);
    }

    // Update a project
    @PutMapping("/{id}")
    public ResponseEntity<ProjectFront> updateProject(@PathVariable UUID id,
                                                      @RequestParam("name") String name,
                                                      @RequestParam("description") String description,
                                                      @RequestParam("image") MultipartFile image,
                                                      @RequestParam("details") String details,         // New parameter
                                                      @RequestParam("technologies") String technologies, // New parameter
                                                      @RequestParam("duration") String duration) throws IOException {  // New parameter

        ProjectFront projectFront = new ProjectFront();
        projectFront.setName(name);
        projectFront.setDescription(description);
        projectFront.setImage(image.getBytes()); // Convert the image to binary data
        projectFront.setDetails(details);          // Set details
        projectFront.setTechnologies(technologies); // Set technologies
        projectFront.setDuration(duration);        // Set duration

        // Update the project using the service
        ProjectFront updatedProject = projectFrontService.updateProject(id, projectFront);
        return updatedProject != null ? ResponseEntity.ok(updatedProject) : ResponseEntity.notFound().build();
    }

    // Delete a project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        projectFrontService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
