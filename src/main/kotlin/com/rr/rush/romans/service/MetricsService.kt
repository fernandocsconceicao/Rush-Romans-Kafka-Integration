package com.rr.rush.romans.service

import com.ti89.dto.front.request.MetricsDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.codec.json.Jackson2JsonEncoder
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