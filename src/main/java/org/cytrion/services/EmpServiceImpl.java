/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.cytrion.exceptions.EmpNotFoundException;
import org.cytrion.models.Employee;
import org.cytrion.utility.EntityManagerUtil;

/**
 *
 * @author Ravi Kumar
 */
public class EmpServiceImpl implements EmpService {

    private static final EntityManagerUtil entityManagerUtil;

    static {
        entityManagerUtil = new EntityManagerUtil();
    }

    @Override
    public List<Employee> getAllEmps() {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT E FROM Employee E");
        return (List<Employee>) query.getResultList();
    }

    @Override
    public Employee getEmpById(Integer id) throws EmpNotFoundException {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        Employee emp= entityManager.find(Employee.class, id);
        if(emp==null){
            throw new EmpNotFoundException("Employee Not Exist");
        }else{
            return emp;
        }
    }

    @Override
    public Employee getEmpbyMail(String mail) throws EmpNotFoundException {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        return entityManager.createQuery("select e from Employee e where email=:email", Employee.class).setParameter("email", mail).getSingleResult();
    }

    @Override
    public Employee updateEmp(Employee emp) throws EmpNotFoundException {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Employee emp1 = entityManager.find(Employee.class, emp.getId());
        emp1.setName(emp.getName());
        emp1.setPassword(emp.getPassword());
        emp1.setEmail(emp.getEmail());
        emp1.setSalary(emp.getSalary());
        entityManager.getTransaction().commit();
        return emp;
    }

    @Override
    public Employee deleteEmp(Employee emp) throws EmpNotFoundException {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        emp = entityManager.find(Employee.class, emp.getId());
        System.out.println(emp);
        entityManager.remove(emp);
        entityManager.getTransaction().commit();
        return emp;
    }

    @Override
    public Employee saveEmp(Employee emp) {

        EntityManager entityManager = entityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
        try {
            //System.out.println(emp.getEncodedEmail());
            return getEmpbyMail(emp.getEncodedEmail());
        } catch (EmpNotFoundException ex) {
            return null;
        }
    }

    @Override
    public boolean isMailAvailable(String email) {
        try {
            getEmpbyMail(email);
            return false;
        } catch (EmpNotFoundException e) {
            return true;
        }
    }

}
