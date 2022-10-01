package com.rr.rush.romans.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@Configuration
class KafkaConsumerConfig {
    @Bean
    fun customConsumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(kafkaPropertiesConfig())
    }
    fun kafkaPropertiesConfig(): Map<String, Any> {
        val props = HashMap<String, Any>()
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer().javaClass)
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer().javaClass)
        return props
    }
    @Bean
    fun kafkaListenerContainerFactory (consumerFactory: ConsumerFactory<String,String>):KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>>{
        val factory = ConcurrentKafkaListenerContainerFactory<String,String>()
        factory.consumerFactory = consumerFactory
        return factory
    }
}

