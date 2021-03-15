package com.baby.dev.learning.basicspringboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/test"])
class HelloController {

    @GetMapping("/hello")
    fun sayHello() : String = "Hello from baby developer"
}