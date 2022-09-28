package com.rr.rush.romans.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig {

    @Autowired
    lateinit var kafkaProperties:Map<String, Any>

    @Bean
    fun customProducerFactory(): ProducerFactory<String, String> {
        return DefaultKafkaProducerFactory(kafkaProperties)
    }


}