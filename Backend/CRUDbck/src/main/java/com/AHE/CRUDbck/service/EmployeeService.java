package com.AHE.CRUDbck.service;

import com.AHE.CRUDbck.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

   public List<Employee> getAllEmployees();
   public Employee createEmployee(Employee employee);
   public Employee getEmployeeById(long id);
   public Employee updateEmployee(long id,Employee employee);
   public void deleteEmployee(long id);
}
