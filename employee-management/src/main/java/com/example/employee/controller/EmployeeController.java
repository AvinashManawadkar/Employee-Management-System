package com.example.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp){
        return service.saveEmployee(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
    }
}