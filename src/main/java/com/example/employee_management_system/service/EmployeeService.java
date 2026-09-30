package com.example.employee_management_system.service;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity<List<Employee>> getAllEmployees(){
        try{
            return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Employee>> getEmployeeByDepartment(String department){
        List<Employee> employees = employeeRepository.findByDepartment(department);
        if (employees.isEmpty()){
            throw new NoSuchElementException("No employees found in department: " + department);
        }
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    public ResponseEntity<String> addEmployee(Employee employee){
        Employee saved = employeeRepository.save(employee);
        return new ResponseEntity<>("Employee saved successfully", HttpStatus.CREATED);
    }
}
