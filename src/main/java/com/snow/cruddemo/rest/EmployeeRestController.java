package com.snow.cruddemo.rest;

import com.snow.cruddemo.entity.Employee;
import com.snow.cruddemo.service.EmployeeService;
import com.snow.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService ;

    // quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeServiceImpl theEmployeeService) { //constructor injection
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found -" + employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees/")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing Employee
    @PutMapping("/employees")
    public Employee updateEmployees(@RequestBody Employee theEmployee) { // use ID of employee to update with updated info
        Employee dbEmployee = employeeService.save(theEmployee);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found -" + theEmployee);
        }
        return dbEmployee;
    }

    // add mapping for Delete /employees - delete existing Employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee not found -" + employeeId);
        }
        employeeService.deleteByID(employeeId);
        return "Deleted Employee - " + employeeId;
    }
}
