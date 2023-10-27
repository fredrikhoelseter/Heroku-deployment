package com.example.heroku.deployment.controllers;


import com.example.heroku.deployment.entities.Employee;
import com.example.heroku.deployment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/save/{id}/{name}")
    public void saveEmployee(@PathVariable("id") Long id, @PathVariable("name") String name) {
        Employee employee = new Employee(id, name);
        employeeService.save(employee);

    }
}
