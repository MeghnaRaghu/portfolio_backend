package com.example.portfolio.Repository;

import com.example.portfolio.Model.ProjectFront;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectFrontRepository extends JpaRepository<ProjectFront, UUID> {
    // You can add custom queries here if needed
}
