package com.example.hotmeals.core.repositories

import com.example.hotmeals.core.retrofit.AuthApi
import retrofit2.Response

class AuthRepository(private val authApi: AuthApi) {


    suspend fun login(identifier: String,
                      password: String): Response<AuthApi.LoginResponse> {
        val request = AuthApi.LoginRequest(identifier, password)
        return authApi.loginUser(request)
    }

    suspend fun register(name: String,
                         email: String,
                         password:String,
                         phoneNumber: String): Response<AuthApi.RegisterResponse> {
        val request = AuthApi.RegisterRequest(email, password, name, phoneNumber)
        return authApi.registerUser(request)
    }


}