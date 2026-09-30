package com.example.employee_management_system.controller;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/allEmoloyees")
    public ResponseEntity<List<Employee>> getAllEmoployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department/{department")
    public ResponseEntity<List<Employee>> getEmployeeByDepartment(String department){
        return employeeService.getEmployeeByDepartment(department);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
