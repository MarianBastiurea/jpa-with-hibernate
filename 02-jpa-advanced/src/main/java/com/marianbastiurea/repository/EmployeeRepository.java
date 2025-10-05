package com.marianbastiurea.repository;

import com.marianbastiurea.entity.*;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public void  insertEmployee(Employee employee){
        entityManager.persist(employee);
    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }


}
