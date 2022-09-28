package com.rr.rush.romans

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication

class RushRomansApplication : CommandLineRunner {
    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>
    override fun run(vararg args: String?) {
        for (i in 1..10) {
            kafkaTemplate.send("metrics", "{\"email\": \"fernando@gmail.com\"}")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<RushRomansApplication>(*args)
    println(BCryptPasswordEncoder().encode("123"))
}