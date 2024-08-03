package com.example.Base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.fetchEmployee(id));
    }

    @GetMapping(value="/{name}", produces = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable String name) {
        return ResponseEntity.ok(employeeService.fetchEmployee(name));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }
}

