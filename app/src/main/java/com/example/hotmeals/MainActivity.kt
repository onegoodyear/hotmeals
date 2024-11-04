package com.example.hotmeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotmeals.screens.GetStartedScreen
import com.example.hotmeals.screens.LoginScreen
import com.example.hotmeals.screens.RegisterScreen
import com.example.hotmeals.screens.router.Router
import com.example.hotmeals.ui.theme.HotmealsTheme
import com.example.hotmeals.viewmodels.AuthViewModel
import com.example.hotmeals.viewmodels.RegisterViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory(
            (application as HotMealsApplication).authRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HotmealsTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavHost (
                        navController = navController,
                        authViewModel = authViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController, authViewModel: AuthViewModel, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "get_started",
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
//        composable(Router.Register.route) {
//            RegisterScreen(
//                navController = navController,
//                registerViewModel = RegisterViewModel(),
//                authViewModel = authViewModel
//            )
//        }
    }
}
