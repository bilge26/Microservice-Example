package com.example.employee.entity;

import com.example.employer.entity.Employer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column
    private String role;

    @Column
    private LocalDate HireDate;

    @Column
    private int level;

    @Column
    private double salary;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}
    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}
    public LocalDate getHireDate() {return HireDate;}
    public void setHireDate(LocalDate HireDate) {this.HireDate = HireDate;}
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
