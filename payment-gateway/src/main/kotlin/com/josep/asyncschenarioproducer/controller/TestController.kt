package com.josep.asyncschenarioproducer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/{code}")
    fun produce(@PathVariable code: String): String {
        return code
    }
}
