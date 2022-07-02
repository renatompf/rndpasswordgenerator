package com.example.randompasswordgeneratorweb.Models

import com.example.randompasswordgeneratorweb.Exceptions.InvalidLength
import com.example.randompasswordgeneratorweb.Exceptions.InvalidNumberOfParameters
import java.security.SecureRandom

class Password(
    private val useLower : Boolean,
    private val useUpper : Boolean,
    private val useNumbers : Boolean,
    private val useSpecials : Boolean,
    private val length: Int
    ) {

    // Password's characters
    private val upperCaseLetters: CharArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
    private val lowerCaseLetters: CharArray = "abcdefghijklmnopqrstuvwxyz".toCharArray()
    private val specialCharacters: CharArray = "@#$%&({[]})<>".toCharArray()
    private val numbers: CharArray = "1234567890".toCharArray()

    fun generatePassword() : String{
        if(length < 8)
            throw InvalidLength();

        val random = SecureRandom()
        val password = StringBuilder()

        val charCategoryToBeUsed = mutableListOf<CharArray>()
        if(this.useUpper)
            charCategoryToBeUsed.add(upperCaseLetters)
        if(this.useLower)
            charCategoryToBeUsed.add(lowerCaseLetters)
        if(this.useNumbers)
            charCategoryToBeUsed.add(numbers);
        if(this.useSpecials)
            charCategoryToBeUsed.add(specialCharacters);

        if(charCategoryToBeUsed.isEmpty())
            throw InvalidNumberOfParameters()

        for( i in 0..length-1){
            val charCategory : CharArray = charCategoryToBeUsed.get(random.nextInt(charCategoryToBeUsed.size))
            password.append(charCategory[random.nextInt(charCategory.size)])
        }

        return String(password)
    }
}