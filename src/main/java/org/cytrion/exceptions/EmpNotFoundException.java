/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.exceptions;

/**
 *
 * @author Ravi Kumar
 */
public class EmpNotFoundException extends Exception {
    public String message;

    public EmpNotFoundException(String message) {
        this.message = message;
    }
    
}
