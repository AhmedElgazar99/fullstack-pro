package com.AHE.CRUDbck.service;

import com.AHE.CRUDbck.exception.ResourceNotFoundException;
import com.AHE.CRUDbck.model.Employee;
import com.AHE.CRUDbck.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not exist with id :"+id));
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if(employeeRepository.existsById(id)){
            employee.setId(id);
            return  employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not exist with id :"+id));
        employeeRepository.delete(employee);
    }
}
