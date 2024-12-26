package com.example.hotmeals.views.router

sealed class Router(val route: String) {

    data object GetStarted : Router("get_started")
    data object Register : Router("register")
    data object Login : Router("login")

    data object Profile : Router("profile")

    data object Restaurants : Router("restaurants")
    data object RestaurantDetails : Router("restaurant_details/{restaurantId}") {
        fun createRoute(restaurantId: String) = "restaurant_details/$restaurantId"
    }

    data object Menu : Router("menu/{restaurantId}") {
        fun createRoute(restaurantId: String) = "menu/$restaurantId"
    }
    data object Cart : Router("cart")
    data object OrderSummary : Router("order_summary")

    data object OrderHistory : Router("order_history")
    data object OrderTracking : Router("order_tracking/{orderId}") {
        fun createRoute(orderId: String) = "order_tracking/$orderId"
    }

    data object RateAndReview : Router("rate_and_review/{restaurantId}") {
        fun createRoute(restaurantId: String) = "rate_and_review/$restaurantId"
    }

    data object Settings : Router("settings")
    data object HelpCenter : Router("help_center")

    data object Home : Router("home")

    data object Orders: Router("orders")

}
