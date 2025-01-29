package com.example.portfolio.Repository;

import com.example.portfolio.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillsRepository extends JpaRepository<Skill, UUID> {
}
