package com.damonx.asynchmethod.service;

import com.damonx.asynchmethod.model.User;

import java.util.concurrent.CompletableFuture;

public interface LookupService
{
    CompletableFuture<User> findUser(String user) throws InterruptedException;
}
