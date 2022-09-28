package com.rr.rush.romans.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaConfig {
    @Bean
    fun kafkaPropertiesConfig(): Map<String, Any> {
        val props = HashMap<String, Any>()
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer().javaClass)
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer().javaClass)
        return props
    }
    @Bean
    fun kafkaTemplate(producerFactory: ProducerFactory<String, String>): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory)
    }
}