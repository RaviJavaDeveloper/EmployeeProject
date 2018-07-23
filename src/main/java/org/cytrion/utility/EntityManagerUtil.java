/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ravi Kumar
 */
public class EntityManagerUtil {
    private static final EntityManagerFactory emFactory;
    static{
        emFactory=Persistence.createEntityManagerFactory("employee");
    }
    
    public EntityManager getEntityManager(){
        return emFactory.createEntityManager();  
    }
    public void close(){
        emFactory.close();
    }    
}
