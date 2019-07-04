package com.example.springjpa.springJPA.dao;

import com.example.springjpa.springJPA.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl  implements EmployeeDao{
    //define feilds for Entity Manager
    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<Employee> findAll() {
        //getting session from entity Manager
        Session session=entityManager.unwrap(Session.class);
        Query<Employee> theQuery=session.createQuery("from Employee",Employee.class);
        List<Employee> employeeList=theQuery.list();
        return employeeList;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session=entityManager.unwrap(Session.class);
        Query theQuery=session.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",id);
        theQuery.executeUpdate();
    }

    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }
}
