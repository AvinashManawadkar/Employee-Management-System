package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee saveEmployee(Employee emp){
        return repo.save(emp);
    }

    public Employee updateEmployee(Long id, Employee emp){
        Employee existing = repo.findById(id).orElseThrow();
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setDepartment(emp.getDepartment());
        existing.setSalary(emp.getSalary());
        return repo.save(existing);
    }

    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
}