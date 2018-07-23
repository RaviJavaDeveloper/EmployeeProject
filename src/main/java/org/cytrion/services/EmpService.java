
package org.cytrion.services;

import java.util.List;
import org.cytrion.exceptions.EmpNotFoundException;
import org.cytrion.models.Employee;

/**
 * @author Ravi Kumar
 */
public interface EmpService {
    
    public List<Employee> getAllEmps();
    public Employee getEmpById(Integer id) throws EmpNotFoundException;
    public Employee getEmpbyMail(String mail) throws EmpNotFoundException;
    public Employee updateEmp(Employee emp) throws EmpNotFoundException;
    public Employee deleteEmp(Employee emp) throws EmpNotFoundException;
    public Employee saveEmp(Employee emp);
    public boolean isMailAvailable(String email);    
}
