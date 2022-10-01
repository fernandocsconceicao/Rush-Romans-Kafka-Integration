package com.rr.rush.romans.config

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.KafkaListeners
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.stereotype.Component


@Component
class KafkaListeners {
    @KafkaListener(id= "metrics-listener", topics = ["metrics"])
    fun listener(data:String){
        println("Listener Received")
    }
}