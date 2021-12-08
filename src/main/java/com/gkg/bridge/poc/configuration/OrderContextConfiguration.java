package com.gkg.bridge.poc.configuration;


import com.conversantmedia.util.concurrent.DisruptorBlockingQueue;
import com.gkg.bridge.poc.model.OrderContext;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;


@Configuration
public class OrderContextConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "trade.execution.queue")
    public QueueConfiguration queueConfiguration() {
        return new QueueConfiguration();
    }

    @Bean("requestQueue")
    BlockingQueue <OrderContext> requestQueue(QueueConfiguration queueConfiguration) {
        return new DisruptorBlockingQueue<>(queueConfiguration.getCapacity(), queueConfiguration.getSpinPolicy());
    }


    @Bean("responseQueue")
    BlockingQueue <OrderContext> responseQueue(QueueConfiguration queueConfiguration) {
        return new DisruptorBlockingQueue<>(queueConfiguration.getCapacity(), queueConfiguration.getSpinPolicy());
    }


}
