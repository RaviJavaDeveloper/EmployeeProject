
package org.cytrion.controller;


import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.cytrion.exceptions.EmpNotFoundException;
import org.cytrion.models.Employee;
import org.cytrion.services.EmpService;
import org.cytrion.services.EmpServiceImpl;


/**
 * @author Ravi Kumar
 */
@Path("/rest")
public class EmployeeController{
    private static final EmpService service;
    static{
        service=new EmpServiceImpl();
    }
    
    @GET @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello";
    }
    @GET @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> listEmp(){
      return service.getAllEmps();
    }
    @POST @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee createEmp(Employee emp){
        System.out.println(emp);
        return service.saveEmp(emp);    
    }
    @POST @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee deleteEmp(Employee emp) throws EmpNotFoundException{
        System.out.println(emp);
        return service.deleteEmp(emp);    
    }
    @POST @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee updateEmp(Employee emp) throws EmpNotFoundException{
        System.out.println(emp);
        return service.updateEmp(emp);    
    }
    @GET @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmp(@PathParam("id") @NotNull(message = "number should not be null")
            @Digits(message = "It should be a number",fraction = 0,integer = 5) Integer id){
       try{
           System.out.println("id");
            Employee emp=service.getEmpById(id);
            return Response.status(Response.Status.OK).entity(emp).build();
       }
       catch(EmpNotFoundException e){
           return Response.status(Response.Status.OK).entity("Employee with id:"+id+" is not found").build();
       }
       
    }
}
