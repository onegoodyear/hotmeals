package com.example.hotmeals.core.repositories

import com.example.hotmeals.core.IdManager
import com.example.hotmeals.core.retrofit.AuthApi
import retrofit2.Response

class AuthRepository(private val authApi: AuthApi, private val idManager: IdManager) {

    suspend fun login(body: AuthApi.LoginRequest) = authApi.loginUser(body)

    suspend fun register(body: AuthApi.RegisterRequest) = authApi.registerUser(body)

    fun getId() = idManager.getId()
    fun saveId(id: String) = idManager.saveId(id)
    fun clearId() = idManager.clearId()
}