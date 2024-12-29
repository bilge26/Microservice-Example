package com.example.employer.service;

import com.example.employer.dto.EmployerDTO;
import com.example.employer.entity.Employer;

import java.util.List;

public interface EmployerService {
    List<EmployerDTO> getAllEmployers();
    EmployerDTO getEmployerById(Long id);
    Employer createEmployer(Employer employer);
    Employer updateEmployer(Long id, EmployerDTO employerDTO);
    void deleteEmployer(Long id);
}
