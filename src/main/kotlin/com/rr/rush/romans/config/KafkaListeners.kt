package com.rr.rush.romans.config

import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Slf4j
@Component
class KafkaListeners {
    @KafkaListener(id= "metrics-listener", topics = ["metrics"])
    fun listener(data:String){
        val logger: Logger = LoggerFactory.getLogger(KafkaListeners::class.java)
        logger.info("Metrics Data Received")
    }
}