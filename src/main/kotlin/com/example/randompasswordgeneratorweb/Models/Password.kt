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
    private val specialCharacters: CharArray = "@#$€%&({[]})<>".toCharArray()
    private val numbers: CharArray = "1234567890".toCharArray()

    private val random = SecureRandom.getInstance("SHA1PRNG")
    fun shuffle(password: String) : String {
        val passwordChars = mutableListOf<Char>()
        for (c in password.toCharArray())
            passwordChars.add(c)

        val finalPassword = StringBuilder(password.length)
        while (passwordChars.size != 0) {
            finalPassword.append(passwordChars.removeAt(random.nextInt(passwordChars.size)))
        }
        return finalPassword.toString()
    }

    fun generatePassword(): String {
        if (length < 8)
            throw InvalidLength();

        val password = StringBuilder(length)
        var passwordStartPosition : Int = 0
        val charCategoryToBeUsed = mutableListOf<CharArray>()

        if (this.useUpper) {
            charCategoryToBeUsed.add(upperCaseLetters)
            password.append(upperCaseLetters.get(random.nextInt(upperCaseLetters.size)))
            passwordStartPosition +=1
        }

        if (this.useLower) {
            charCategoryToBeUsed.add(lowerCaseLetters)
            password.append(lowerCaseLetters.get(random.nextInt(lowerCaseLetters.size)))
            passwordStartPosition +=1
        }

        if (this.useNumbers) {
            charCategoryToBeUsed.add(numbers)
            password.append(numbers.get(random.nextInt(numbers.size)))
            passwordStartPosition +=1
        }

        if (this.useSpecials) {
            charCategoryToBeUsed.add(specialCharacters)
            password.append(specialCharacters.get(random.nextInt(specialCharacters.size)))
            passwordStartPosition +=1
        }

        if (charCategoryToBeUsed.isEmpty())
            throw InvalidNumberOfParameters()

        for (i in passwordStartPosition until length) {
            val charCategory: CharArray = charCategoryToBeUsed.get(random.nextInt(charCategoryToBeUsed.size))
            password.append(charCategory[random.nextInt(charCategory.size)])
        }

        return shuffle(password.toString())
    }
}