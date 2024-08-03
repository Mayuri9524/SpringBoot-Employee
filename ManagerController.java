package com.example.Base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<Manager> getManager(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.fetchManager(id));
    }

    @GetMapping(value="/{name}", produces = "application/json")
    public ResponseEntity<Manager> getManager(@PathVariable String name) {
        return ResponseEntity.ok(managerService.fetchManager(name));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Manager>> getAll() {
        return ResponseEntity.ok(managerService.findAll());
    }
}
