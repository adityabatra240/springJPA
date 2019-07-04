package com.example.springjpa.springJPA.restControllers;

import com.example.springjpa.springJPA.dao.EmployeeDao;
import com.example.springjpa.springJPA.entity.Employee;
import com.example.springjpa.springJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    @PostMapping("/employees")
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable int id){
        employeeService.deleteById(id);
    }
}
