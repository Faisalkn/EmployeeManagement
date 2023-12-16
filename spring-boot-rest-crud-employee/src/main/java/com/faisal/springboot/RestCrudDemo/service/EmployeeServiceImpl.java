package com.faisal.springboot.RestCrudDemo.service;

import com.faisal.springboot.RestCrudDemo.dao.EmployeeDao;
import com.faisal.springboot.RestCrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   private final EmployeeDao myEmployeeDao;

   @Autowired
    public EmployeeServiceImpl(final EmployeeDao theEmployeeDao) {
        myEmployeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return myEmployeeDao.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return myEmployeeDao.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return myEmployeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
       myEmployeeDao.deleteById(theId);
    }
}
