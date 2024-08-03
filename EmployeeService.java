package com.example.Base;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    @PostConstruct
    public void init() {
        employees.add(new Employee(1L, "Mayuri", "SystemEngineer", 45000.0));
        employees.add(new Employee(2L, "Mayuri", "SystemEngineer", 55000.0));
    }

    public Employee fetchEmployee(Long id) {
        return employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Employee fetchEmployee(String name) {
        return employees.stream()
                .filter(emp -> emp.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }
}
