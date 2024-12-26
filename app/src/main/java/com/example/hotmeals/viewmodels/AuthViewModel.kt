package com.example.hotmeals.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hotmeals.core.repositories.AuthRepository
import com.example.hotmeals.core.retrofit.AuthApi
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository): ViewModel() {
    var name = mutableStateOf("")
    var email = mutableStateOf("")
    var identifier = mutableStateOf("")
    var password = mutableStateOf("")
    var loading = mutableStateOf(false)
    var success = mutableStateOf(false)
    var error = mutableStateOf("")
    var isLoggedIn = mutableStateOf(false)

    fun login() {
        loading.value = true
        success.value = false
        error.value = ""
        viewModelScope.launch {
            try {
                val response = authRepository.login(AuthApi.LoginRequest(email.value, password.value))
                if (response.isSuccessful) {
                    success.value = true
                    isLoggedIn.value = true
                    loading.value = false
                } else {
                    error.value = response.message()
                    if (error.value.isBlank()) {
                        error.value = response.code().toString()
                    }
                    loading.value = false
                }
            } catch (e: Exception) {
                Log.e("LoginError", "Login failed", e)
                error.value = e.message ?: "An error occurred"
                loading.value = false
            }
        }
    }

    class Factory(private val authRepository: AuthRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(authRepository) as T
        }
    }
}
