/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.models;

import org.cytrion.utility.Base64Util;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;



/**
 * @author Ravi Kumar
 */
@Table(name = "employee")
@Entity
public class Employee implements Serializable{
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "uname")
    private String name;
    @Column(name="email",unique = true)
    @Min(value = 6,message = "Atleast 6")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name="joiningdate")
    private Date joindate;
    @Column(name = "salary")
    private Integer salary;
    @Column(name="dateofbirth")
    private Date dob;
    @Column(name = "deptname")
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Base64Util.decode(email);
    }
     public String getEncodedEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Base64Util.encode(email);
    }

    public String getPassword() {
        return Base64Util.decode(password);
    }

    public void setPassword(String password) {
        this.password = Base64Util.encode(password);
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", joindate=" + joindate + ", salary=" + salary + ", dob=" + dob + ", department=" + department + '}';
    }
    
    
    
}
