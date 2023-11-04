package com.miu.lab4_task1to6

import java.io.Serializable

data class User(val firstName: String, val lastName: String, val username: String, val password: String) :
    Serializable
 {
    init {
        require(firstName.isNotBlank()) { "First name cannot be blank" }
        require(lastName.isNotBlank()) { "Last name cannot be blank" }
        require(username.isNotBlank() && username.contains("@")) { "Username must be a valid email" }
        require(password.length >= 6) { "Password must be at least 6 characters long" }
    }
}
