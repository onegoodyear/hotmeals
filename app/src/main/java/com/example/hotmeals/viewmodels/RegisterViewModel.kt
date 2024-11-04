package com.example.hotmeals.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotmeals.core.repositories.AuthRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val authRepository: AuthRepository): ViewModel() {
    var name = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var phoneNumber = mutableStateOf("")
    var phone = mutableStateOf("")
    var loading = mutableStateOf(false)
    var success = mutableStateOf(false)
    var error = mutableStateOf("")
    var isLoggedIn = mutableStateOf(false)


    fun register() {
        loading.value = true
        success.value = false
        error.value = ""
        viewModelScope.launch {
            val response = authRepository.register(name.value, email.value, password.value, phoneNumber.value)
            if (response.isSuccessful) {
                success.value = true
                isLoggedIn.value = true
            }
            else {
                error.value = response.message()
                if (error.value.isBlank()) {
                    error.value = response.code().toString()
                }
            }
        }
    }
}