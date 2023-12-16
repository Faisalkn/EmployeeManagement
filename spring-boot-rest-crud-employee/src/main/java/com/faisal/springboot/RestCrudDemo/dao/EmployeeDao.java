package com.faisal.springboot.RestCrudDemo.dao;

import com.faisal.springboot.RestCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
