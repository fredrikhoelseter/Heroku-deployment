package com.example.heroku.deployment.services;

import com.example.heroku.deployment.entities.Employee;
import com.example.heroku.deployment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        return optionalEmployee.orElse(null);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }
}
