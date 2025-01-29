package com.example.portfolio.Controller;

import com.example.portfolio.Model.Education;
import com.example.portfolio.Model.Skill;
import com.example.portfolio.Service.EducationService;
import com.example.portfolio.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class DataController {

    @Autowired
    private EducationService educationService;

    @Autowired
    private SkillService skillService;

    // Education Endpoints
    @GetMapping("/education")
    public List<Education> getEducation() {
        return educationService.getAllEducation();
    }

    @PostMapping("/education")
    public Education addEducation(@RequestBody Education education) {
        return educationService.addEducation(education);
    }

    // Skills Endpoints
    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return skillService.getAllSkills();
    }

    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill) {
        return skillService.addSkill(skill);
    }
}
