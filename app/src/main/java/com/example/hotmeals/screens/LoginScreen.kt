package com.example.hotmeals.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotmeals.ui.theme.Typography
import com.example.hotmeals.ui.theme.primaryColor
import com.example.hotmeals.ui.theme.white
import com.example.hotmeals.viewmodels.AuthViewModel
import com.example.hotmeals.R
import com.example.hotmeals.screens.router.Router

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel, redirectedRoute: String? = null) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Login to your account",
            style = Typography.titleLarge,
            color = primaryColor,
            modifier = Modifier.padding(vertical = 40.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = authViewModel.email.value,
                onValueChange = { authViewModel.email.value = it },
                label = { Text(text = "Email", color = primaryColor, style = Typography.bodySmall) },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Enter your email", color = primaryColor.copy(0.5f), style = Typography.bodySmall) },
                textStyle = Typography.bodySmall
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = authViewModel.password.value,
                onValueChange = { authViewModel.password.value = it },
                label = { Text(text = "Password", color = primaryColor, style = Typography.bodySmall) },
                placeholder = { Text(text = "Enter a password", color = primaryColor.copy(0.5f), style = Typography.bodySmall) },
                shape = RoundedCornerShape(12.dp),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = Typography.bodySmall
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = white,
                    containerColor = primaryColor
                ),
                shape = RoundedCornerShape(12.dp),
                onClick = {
                    authViewModel.login()
                }
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    modifier = Modifier.padding(7.dp),
                    style = Typography.bodySmall,
                )
                if (authViewModel.loading.value) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp).padding(7.dp),
                        color = Color.White
                    )
                }
            }

            if (authViewModel.error.value.isNotEmpty()) {
                Text(
                    text = authViewModel.error.value,
                    color = Color.Red,
                    style = Typography.bodySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Text(
            text = "Forgot password?",
            style = Typography.bodySmall,
            color = primaryColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            modifier = Modifier
                .padding(15.dp)
                .clickable { navController.navigate("register") },
            text = "Don't have an account? Register",
            style = Typography.bodySmall,
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Or connect with",
            style = Typography.bodySmall,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp), horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                // Handle Google login if implemented
            }) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon", tint = Color.Unspecified
                )
            }
        }
    }

    // Navigation when login is successful
    LaunchedEffect(key1 = authViewModel.success.value) {
        if (authViewModel.success.value) {
            navController.navigate(redirectedRoute ?: Router.Profile.route)
        }
    }

    // Redirect if already logged in
    LaunchedEffect(key1 = authViewModel.isLoggedIn.value) {
        if (authViewModel.isLoggedIn.value) {
            navController.navigate(Router.Profile.route)
        }
    }


}
