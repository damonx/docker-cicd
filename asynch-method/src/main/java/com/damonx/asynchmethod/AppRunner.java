package com.damonx.asynchmethod;

import com.damonx.asynchmethod.model.User;
import com.damonx.asynchmethod.service.LookupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner
{

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private LookupService gitHubLookupService;

    @Override
    public void run(final String... args) throws Exception
    {
        // Start the clock
        final long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        final CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        final CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        final CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1, page2, page3).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());

        final long start1 = System.currentTimeMillis();
        final User page4 = gitHubLookupService.findUserSync("PivotalSoftware");
        final User page5 = gitHubLookupService.findUserSync("CloudFoundry");
        final User page6 = gitHubLookupService.findUserSync("Spring-Projects");

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start1));
        logger.info("--> " + page4);
        logger.info("--> " + page5);
        logger.info("--> " + page6);
    }

}
