package com.rr.rush.romans.controller

import com.rr.rush.romans.service.MetricsService
import com.ti89.dto.front.request.MetricsDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @Autowired
    lateinit var service: MetricsService

    @PostMapping("/metrics/combat/send")
    fun metricsUpload(@RequestBody metricsDto: MetricsDto){
        service.uploadMetrics(metricsDto)
    }
}