package com.rr.rush.romans.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.TopicBuilder

@EnableKafka
@Configuration
class KafkaTopicConfig {

    @Bean
    fun metricTopicConfig(): NewTopic{
        return TopicBuilder.name("metrics").build()
    }
}