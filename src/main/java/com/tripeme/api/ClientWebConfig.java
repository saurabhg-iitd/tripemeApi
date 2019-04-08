package com.tripeme.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ClientWebConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    }
    
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	registry.addInterceptor(new MyCustomInterceptor()).addPathPatterns("/**");
    }*/
    
    
    /*@Configuration
    public class MyConfig extends WebMvcConfigurerAdapter{
        @Override
        public void addInterceptors(InterceptorRegistry registry){
            
        }
    }*/
}
