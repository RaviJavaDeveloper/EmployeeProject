package com.cytrion.cfg;

import org.cytrion.models.ValidationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Kumar
 */
public class WebAppConfig extends ResourceConfig{
    public WebAppConfig() {
        System.out.println("Config done");
        // Validation.
        register(ValidationExceptionMapper.class);
        
    }
    
}
