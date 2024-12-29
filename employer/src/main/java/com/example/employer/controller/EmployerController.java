package com.example.employer.controller;

import com.example.employer.dto.EmployerDTO;
import com.example.employer.entity.Employer;
import com.example.employer.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/findAll")
    public List<EmployerDTO> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @GetMapping("/get/{id}")
    public EmployerDTO getEmployerById(@PathVariable Long id) {
        return employerService.getEmployerById(id);
    }

    @PostMapping("/save")
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerService.createEmployer(employer);
    }

    @PutMapping("/update/{id}")
    public Employer updateEmployer(@PathVariable Long id, @RequestBody EmployerDTO employerDTO) {
        return employerService.updateEmployer(id, employerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
    }
}
