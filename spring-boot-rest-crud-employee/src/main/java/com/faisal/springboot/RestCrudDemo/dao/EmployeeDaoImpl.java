package com.faisal.springboot.RestCrudDemo.dao;

import com.faisal.springboot.RestCrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{


    private final EntityManager myEntityManager;

    @Autowired
    public EmployeeDaoImpl(final EntityManager theEntityManager) {
        myEntityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = myEntityManager.createQuery("FROM Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        return myEntityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return myEntityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = findById(theId);
        myEntityManager.remove(employee);
    }
}
