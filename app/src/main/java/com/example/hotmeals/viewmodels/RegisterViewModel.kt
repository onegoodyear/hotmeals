package com.example.hotmeals.viewmodels

import androidx.compose.runtime.mutableStateOf

class RegisterViewModel {
    var name = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var phone = mutableStateOf("")
    var loading = mutableStateOf(false)
}