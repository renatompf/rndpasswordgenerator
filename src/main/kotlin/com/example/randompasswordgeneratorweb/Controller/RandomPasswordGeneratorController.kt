package com.example.randompasswordgeneratorweb.Controller

import com.example.randompasswordgeneratorweb.Models.Password
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RandomPasswordGeneratorController(){

    @GetMapping
    fun generatePassword(
        @RequestParam(required = false, defaultValue = "true") usesLower: Boolean,
        @RequestParam(required = false, defaultValue = "true") usesUpper: Boolean,
        @RequestParam(required = false, defaultValue = "true") usesNumbers: Boolean,
        @RequestParam(required = false, defaultValue = "true") usesSpecials: Boolean,
        @RequestParam(required = true) length: Int
    ) : String
    {
        val password = Password(usesLower, usesUpper, usesNumbers, usesSpecials, length)
        return password.generatePassword()
    }

}