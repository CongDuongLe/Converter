package com.hanndlee.converter.utils.helper

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$")
    return email.matches(emailRegex)
}

fun isValidPassword(password: String): Boolean {
    val passwordRegex = Regex("^(?=.*[0-9])(?=.*[A-Za-z])(?=.*[@_])(?!.*\\s).{6,}$")
    return password.matches(passwordRegex)
}