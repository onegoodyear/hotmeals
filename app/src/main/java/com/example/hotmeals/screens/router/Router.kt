package com.example.hotmeals.screens.router

sealed class Router(val route: String) {
    data object GetStarted : Router("get_started")
    data object Register: Router("register")
}