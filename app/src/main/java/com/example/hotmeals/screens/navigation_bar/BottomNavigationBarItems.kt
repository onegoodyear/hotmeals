package com.example.hotmeals.screens.navigation_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hotmeals.screens.RegisterScreen
import com.example.hotmeals.screens.router.Router

sealed class BottomNavigationBarItems(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object Restaurants : BottomNavigationBarItems(
        title = "Restaurants",
        icon = Icons.Default.Place,
        route = Router.Home.route
    )

    object Orders : BottomNavigationBarItems(
        title = "Orders",
        icon = Icons.Default.ShoppingCart,
        route = Router.Orders.route
    )

    object Profile : BottomNavigationBarItems(
        title = "Profile",
        icon = Icons.Default.Person,
        route = Router.Profile.route
    )

    object Auth : BottomNavigationBarItems(
        title = "Auth",
        icon = Icons.Default.Lock,
        route = Router.Login.route
    )

    object Register : BottomNavigationBarItems(
        title = "Register",
        icon = Icons.Default.Face,
        route = Router.Register.route
    )

    companion object {
        fun values(): List<BottomNavigationBarItems> {
            return listOf(Restaurants, Orders, Profile, Auth, Register)
        }
    }
}
