package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 11:27 PM
 * Project: commodity
 * Package Name: com.kafka.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
public class KafkaConfig {

    /**
     * Auto create topic "t.commodity.order" if one does not exist
     * @return
     */
    @Bean
    public NewTopic topicOrder(){
        return TopicBuilder.name("t.commodity.order").partitions(1).replicas(1).build();
    }

    /**
     * Auto create topic "t.commodity.order.reply" if one does not exist
     * @return
     */
    @Bean
    public NewTopic topicOrderReply(){
        return TopicBuilder.name("t.commodity.order.reply").partitions(1).replicas(1).build();
    }
}
