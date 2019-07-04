package com.example.springjpa.springJPA.dao;

import com.example.springjpa.springJPA.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

    public void save(Employee employee);

    public void deleteById(int id);

    public Employee findById(int id);
}
