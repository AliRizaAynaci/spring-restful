package com.example.restful.service;

import com.example.restful.model.Employee;
import com.example.restful.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeesRepository employeesRepository;

    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeesRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeesRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, Long id) {
        if (!employeesRepository.existsById(employee.getId())) {
            throw new IllegalArgumentException("Employee with id " + employee.getId() + " not found");
        }
        return employeesRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }

}
