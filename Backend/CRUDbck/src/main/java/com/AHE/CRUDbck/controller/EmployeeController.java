package com.AHE.CRUDbck.controller;

import com.AHE.CRUDbck.exception.ResourceNotFoundException;
import com.AHE.CRUDbck.model.Employee;
import com.AHE.CRUDbck.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee= employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee) {

       return ResponseEntity.ok( employeeService.updateEmployee(id,employee));
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id) {
       employeeService.deleteEmployee(id);
        Map<String ,Boolean> response=new HashMap<>();

        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
