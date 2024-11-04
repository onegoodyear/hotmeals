package com.example.hotmeals

import android.app.Application
import com.example.hotmeals.core.repositories.AuthRepository
import com.example.hotmeals.core.retrofit.AuthApi

class HotMealsApplication: Application() {

        override fun onCreate() {
            super.onCreate()
        }

    private val authApi by lazy { AuthApi.create() }

    val authRepository by lazy { AuthRepository(authApi) }

}