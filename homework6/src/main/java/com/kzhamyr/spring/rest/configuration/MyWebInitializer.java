/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Amyr
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return null;
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[]{MyConfig.class};
    }
    
    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }
}
