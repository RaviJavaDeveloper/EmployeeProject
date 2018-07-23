/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.utility;

import javax.persistence.EntityManager;

/**
 *
 * @author Ravi Kumar
 */
public class EMTest {
    public static void main(String[] args) {
        EntityManagerUtil manger=new EntityManagerUtil();
        manger.getEntityManager();
    }
    
}
