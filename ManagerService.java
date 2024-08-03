package com.example.Base;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ManagerService {
    private final List<Manager> managers = new ArrayList<>();

    @PostConstruct
    public void init() {
        managers.add(new Manager(1L, "Komal", "Manager", 45000.0));
        managers.add(new Manager(2L, "Jigyasa", "Manager", 55000.0));
    }

    public Manager fetchManager(Long id) {
        return managers.stream()
                .filter(mag -> mag.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Manager fetchManager(String name) {
        return managers.stream()
                .filter(mag -> mag.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Manager> findAll() {
        return new ArrayList<>(managers);
    }
}
