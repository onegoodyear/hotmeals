package com.example.hotmeals

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hotmeals.views.GetStartedScreen
import com.example.hotmeals.views.HomeScreen
import com.example.hotmeals.views.LoginScreen
import com.example.hotmeals.views.profile.ProfileScreen
import com.example.hotmeals.views.RegisterScreen
import com.example.hotmeals.views.RestaurantsScreen
import com.example.hotmeals.views.navigation.NavItem
import com.example.hotmeals.views.navigation.NavItemBox
import com.example.hotmeals.views.router.Router
import com.example.hotmeals.ui.theme.HotmealsTheme
import com.example.hotmeals.viewmodels.AuthViewModel
import com.example.hotmeals.viewmodels.RegisterViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory(
            (application as HotMealsApplication).authRepository
        )
    }

    private val registerViewModel: RegisterViewModel by viewModels {
        RegisterViewModel.Factory(
            (application as HotMealsApplication).authRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HotmealsTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {BottomNavigationBar(navController)}) { innerPadding ->
                    AppNavHost (
                        navController = navController,
                        authViewModel = authViewModel,
                        registerViewModel = registerViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        window.decorView.apply {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController, authViewModel: AuthViewModel, registerViewModel: RegisterViewModel, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Router.GetStarted.route,
        modifier = modifier
    ) {
        composable(Router.GetStarted.route) {
            GetStartedScreen(navController = navController)
        }
        composable(Router.Login.route) { navBackStackEntry ->
            val redirectRoute = navBackStackEntry.arguments?.getString("redirect")
            LoginScreen(
                navController = navController,
                authViewModel = authViewModel,
                redirectRoute
            )
        }
        composable(Router.Register.route) {
            RegisterScreen(
                navController = navController,
                registerViewModel = registerViewModel,
            )
        }
        composable(Router.Restaurants.route) {
            RestaurantsScreen(
                navController = navController
            )
        }
        composable(Router.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Router.Profile.route) {
            ProfileScreen(
                navController = navController
            )
        }
        composable(Router.Orders.route) {
            Text(text = "Orders")
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.LightGray) {
        NavItem.values().forEach { item ->
            val isSelected = currentRoute == item.route
            NavItemBox(
                navItem = item,
                isSelected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.route) {
                            popUpTo(Router.Home.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
            )
        }
    }
}
