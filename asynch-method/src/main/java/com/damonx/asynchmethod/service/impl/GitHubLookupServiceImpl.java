package com.damonx.asynchmethod.service.impl;

import com.damonx.asynchmethod.model.User;
import com.damonx.asynchmethod.service.LookupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookupServiceImpl implements LookupService
{
    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupServiceImpl.class);

    private final RestTemplate restTemplate;

    public GitHubLookupServiceImpl(final RestTemplateBuilder restTemplateBuilder)
    {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public CompletableFuture<User> findUser(final String user) throws InterruptedException
    {
        logger.info("Looking up " + user);
        final String url = String.format("https://api.github.com/users/%s", user);
        final User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}
