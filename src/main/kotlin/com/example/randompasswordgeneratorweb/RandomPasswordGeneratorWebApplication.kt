package com.example.randompasswordgeneratorweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RandomPasswordGeneratorWebApplication

fun main(args: Array<String>) {
    runApplication<RandomPasswordGeneratorWebApplication>(*args)
}
