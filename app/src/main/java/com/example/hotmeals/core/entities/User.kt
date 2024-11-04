package com.example.hotmeals.core.entities

data class User (
    val id: String,
    val name: String,
    val email: String,
    val googleId: String? = null,
    val pssword: String? = null,
    val phoneNumber: String? = null,
    val address: Address? = null,
    val profilePicture: String? = null,
    val role: String = "user",
    val createdAt:String? = null,

    )

data class Address(
    val street: String? = null,
    val city: String? = null,
    val state: String? = null
)

