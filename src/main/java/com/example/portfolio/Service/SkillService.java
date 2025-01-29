package com.example.portfolio.Service;

import com.example.portfolio.Model.Skill;
import com.example.portfolio.Repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    private SkillsRepository skillsRepository;

    public List<Skill> getAllSkills() {
        return skillsRepository.findAll();
    }

    public Skill addSkill(Skill skill) {
        return skillsRepository.save(skill);
    }

    public Optional<Skill> getSkillById(UUID id) {
        return skillsRepository.findById(id); // Updated method to accept UUID
    }

    public boolean existsById(UUID id) {
        return skillsRepository.existsById(id); // Updated method to accept UUID
    }

    public void deleteSkill(UUID id) {
        skillsRepository.deleteById(id); // Updated method to accept UUID
    }
}
