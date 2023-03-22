package com.example.employee_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    //CRUD operations
    //create
    //void create(Employee employee);

    //read
    List<Employee> findAll();
    Optional<Employee>  getEmployeeById(Integer id);

    //update
    //Employee save(Employee employee);

    //delete
    void deleteById(Integer id);
}
