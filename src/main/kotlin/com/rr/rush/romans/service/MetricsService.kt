package com.rr.rush.romans.service

import com.rr.rush.romans.entity.metrics.ardor.MetricsDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MetricsService {
    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun uploadMetrics(data: MetricsDto){
        kafkaTemplate.send("metrics", data.toString())
    }
}