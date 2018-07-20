
package org.cytrion.services;

import java.util.List;
import org.cytrion.exceptions.UserNotFoundException;
import org.cytrion.models.Employee;

/**
 * @author Ravi Kumar
 */
public interface EmpService {
    
    public List<Employee> getAllEmps();
    public Employee getEmpById(Integer id) throws UserNotFoundException;
    public Employee getEmpbyMail(String mail) throws UserNotFoundException;
    public Employee updateEmp(Employee emp) throws UserNotFoundException;
    public Employee deleteEmp(Employee emp) throws UserNotFoundException;
    public Employee saveEmp(Employee emp);
    public boolean checkMailAvailability(String email);    
}
