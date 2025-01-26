    package com.example.portfolio.Repository;

    import com.example.portfolio.Model.Project;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface ProjectRepository extends JpaRepository<Project, Long> {
        // Custom query methods can be added here if needed
    }