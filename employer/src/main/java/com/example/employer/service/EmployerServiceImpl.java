package com.example.employer.service.impl;

import com.example.employer.dto.EmployerDTO;
import com.example.employer.entity.Employer;
import com.example.employer.repository.EmployerRepository;
import com.example.employee.entity.Employee;
import com.example.employer.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<EmployerDTO> getAllEmployers() {
        List<Employer> employers = employerRepository.findAll();
        return employers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployerDTO getEmployerById(Long id) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found with id: " + id));
        return convertToDTO(employer);
    }

    @Override
    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public Employer updateEmployer(Long id, EmployerDTO employerDTO) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found with id: " + id));
        employer.setName(employerDTO.getName());
        employer.setAddress(employerDTO.getAddress());
        return employerRepository.save(employer);
    }

    @Override
    public void deleteEmployer(Long id) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found with id: " + id));
        if (!employer.getEmployees().isEmpty()) {
            throw new RuntimeException("Cannot delete Employer. It has associated Employees.");
        }
        employerRepository.delete(employer);
    }

    private EmployerDTO convertToDTO(Employer employer) {
        EmployerDTO employerDTO = new EmployerDTO();
        employerDTO.setId(employer.getId());
        employerDTO.setName(employer.getName());
        employerDTO.setAddress(employer.getAddress());
        employerDTO.setEmployeeIds(employer.getEmployees().stream()
                .map(Employee::getId)
                .collect(Collectors.toList()));
        return employerDTO;
    }
}
