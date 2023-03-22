package com.example.employee_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_api.exception.ResourceNotFoundException;
import com.example.employee_api.model.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import com.example.employee_api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        if(employees.isEmpty())
            throw new ResourceNotFoundException("No employees found");

        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.getEmployeeById(id).orElseThrow(() -> new ResourceNotFoundException("No employee found with id: " + id));
    }

    @Override
    public Employee update(int id, Employee employee) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);

        if(!employeeOpt.isPresent())
            throw new ResourceNotFoundException("No employee found with id: " + id);
        
        Employee employeeToUpdate = new Employee(
            id,
            employee.getFirstname().isEmpty() ? employeeOpt.get().getFirstname(): employee.getFirstname(),
            employee.getLastname().isEmpty() ? employeeOpt.get().getLastname(): employee.getLastname(),
            employee.getSalary() == null ? employeeOpt.get().getSalary() : employee.getSalary()
        );

        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
    
}
