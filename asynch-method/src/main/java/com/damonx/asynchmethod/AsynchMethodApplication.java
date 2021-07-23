package com.damonx.asynchmethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsynchMethodApplication {

    public static void main(final String[] args)
    {
        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(AsynchMethodApplication.class, args).close();
    }
}
