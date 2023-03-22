package com.example.employee_api.service;

import java.util.List;

import com.example.employee_api.model.Employee;

public interface EmployeeService {
    void create(Employee employee);
    List<Employee> getAll();
    Employee findById(Integer id);
    Employee update(int id, Employee employee);
    void deleteById(Integer id);
}
