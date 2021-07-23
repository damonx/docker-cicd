package com.damonx.asynchmethod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class SpringAsyncConfig
{
    /**
     * Create a customized ThreadPoolTaskExecutor bean to execute tasks.
     *
     * @param springThreadPoolProperties The {@link SpringThreadPoolProperties} property class which
     *        stores the customized initialized parameters for {@link ThreadPoolTaskExecutor}.
     * @return The customized Executor bean.
     */
    @Bean(name = "ServiceTaskExecutor")
    public Executor createTaskExecutorBean(final SpringThreadPoolProperties springThreadPoolProperties)
    {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(springThreadPoolProperties.getThreadPoolMaxPoolSize());
        executor.setCorePoolSize(springThreadPoolProperties.getThreadPoolCorePoolSize());
        executor.setQueueCapacity(springThreadPoolProperties.getThreadPoolQueueCapacity());
        executor.setKeepAliveSeconds(springThreadPoolProperties.getThreadPoolKeepAliveSeconds());
        executor.setThreadNamePrefix(springThreadPoolProperties.getThreadPoolThreadNamePrefix());
        executor.initialize();
        return executor;
    }
}
