package com.ryggsekk.promosoffers.configuration;
 
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringSecTestConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}