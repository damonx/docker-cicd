package com.damonx.asynchmethod.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Non-refreshScoped properties for thread pool executor.
 */
@Component
@ConfigurationProperties("dasl.health.spring")
public class SpringThreadPoolProperties
{
    private int threadPoolCorePoolSize;

    private int threadPoolMaxPoolSize;

    private int threadPoolQueueCapacity;

    private int threadPoolKeepAliveSeconds;

    private String threadPoolThreadNamePrefix;

    public int getThreadPoolCorePoolSize()
    {
        return threadPoolCorePoolSize;
    }

    public void setThreadPoolCorePoolSize(final int threadPoolCorePoolSize)
    {
        this.threadPoolCorePoolSize = threadPoolCorePoolSize;
    }

    public int getThreadPoolMaxPoolSize()
    {
        return threadPoolMaxPoolSize;
    }

    public void setThreadPoolMaxPoolSize(final int threadPoolMaxPoolSize)
    {
        this.threadPoolMaxPoolSize = threadPoolMaxPoolSize;
    }

    public int getThreadPoolQueueCapacity()
    {
        return threadPoolQueueCapacity;
    }

    public void setThreadPoolQueueCapacity(final int threadPoolQueueCapacity)
    {
        this.threadPoolQueueCapacity = threadPoolQueueCapacity;
    }

    public int getThreadPoolKeepAliveSeconds()
    {
        return threadPoolKeepAliveSeconds;
    }

    public void setThreadPoolKeepAliveSeconds(final int threadPoolKeepAliveSeconds)
    {
        this.threadPoolKeepAliveSeconds = threadPoolKeepAliveSeconds;
    }

    public String getThreadPoolThreadNamePrefix()
    {
        return threadPoolThreadNamePrefix;
    }

    public void setThreadPoolThreadNamePrefix(final String threadPoolThreadNamePrefix)
    {
        this.threadPoolThreadNamePrefix = threadPoolThreadNamePrefix;
    }
}
