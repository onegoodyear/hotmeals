package com.example.hotmeals.views.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hotmeals.views.router.Router

sealed class NavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object Restaurants : NavItem(
        title = "Restaurants",
        icon = Icons.Default.Place,
        route = Router.Home.route
    )

    object Orders : NavItem(
        title = "Orders",
        icon = Icons.Default.ShoppingCart,
        route = Router.Orders.route
    )

    object Profile : NavItem(
        title = "Profile",
        icon = Icons.Default.Person,
        route = Router.Profile.route
    )

    object Auth : NavItem(
        title = "Auth",
        icon = Icons.Default.Lock,
        route = Router.Login.route
    )

    object Register : NavItem(
        title = "Register",
        icon = Icons.Default.Face,
        route = Router.Register.route
    )

    companion object {
        fun values(): List<NavItem> {
            return listOf(Restaurants, Orders, Profile, Auth, Register)
        }
    }
}
