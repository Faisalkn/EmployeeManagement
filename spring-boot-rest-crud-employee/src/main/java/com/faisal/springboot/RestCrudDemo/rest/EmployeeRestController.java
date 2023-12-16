package com.faisal.springboot.RestCrudDemo.rest;

import com.faisal.springboot.RestCrudDemo.entity.Employee;
import com.faisal.springboot.RestCrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService myEmployeeService;

    @Autowired
    public EmployeeRestController(final EmployeeService theEmployeeService) {
         myEmployeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return myEmployeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee find(@PathVariable int employeeId){
        Employee theEmployee = myEmployeeService.findById(employeeId);
        if(theEmployee == null){
            throw new NullPointerException("Employee with the Id is : " + null);
        }else{
            return theEmployee;
        }
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return myEmployeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return myEmployeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee findEmployee = myEmployeeService.findById(employeeId);
        if(findEmployee == null){
            throw new NullPointerException("The employee id is not found : " + employeeId);
        }
        myEmployeeService.deleteById(employeeId);
        return "Employee with the id : " +  employeeId + " is deleted.";
    }
}
