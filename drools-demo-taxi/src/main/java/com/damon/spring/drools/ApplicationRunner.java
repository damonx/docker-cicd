package com.damon.spring.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackageClasses = { ApplicationRunner.class })
public class ApplicationRunner extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application)
    {
        return application.sources(ApplicationRunner.class);
    }
    /**
     * Entry point for the micro-service.
     *
     * @param args  Provided command line arguments.
     */
    public static void main(final String[] args)
    {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
