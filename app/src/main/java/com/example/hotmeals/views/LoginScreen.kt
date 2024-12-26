package com.example.hotmeals.views

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotmeals.ui.theme.Typography
import com.example.hotmeals.ui.theme.primaryColor
import com.example.hotmeals.ui.theme.white
import com.example.hotmeals.viewmodels.AuthViewModel
import com.example.hotmeals.R
import com.example.hotmeals.views.router.Router

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel, redirectedRoute: String? = null) {
    val context = LocalContext.current
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
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                onValueChange = { authViewModel.email.value = it },
                label = { Text(text = "identfier", color = primaryColor, style = Typography.bodyMedium) },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "email or phone number", color = primaryColor.copy(0.5f), style = Typography.bodyMedium) },
                textStyle = Typography.bodyMedium
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = authViewModel.password.value,
                onValueChange = { authViewModel.password.value = it },
                label = { Text(text = "password", color = primaryColor, style = Typography.bodyMedium) },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "passwordIcon") },
                placeholder = { Text(text = "...password", color = primaryColor.copy(0.5f), style = Typography.bodyMedium) },
                shape = RoundedCornerShape(12.dp),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = Typography.bodyMedium
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
                    style = Typography.bodyMedium,
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
                    style = Typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Text(
            text = "Forgot password?",
            style = Typography.bodyMedium,
            color = primaryColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            modifier = Modifier
                .padding(15.dp)
                .clickable { navController.navigate(Router.Register.route) },
            text = "Don't have an account? Register",
            style = Typography.bodyMedium,
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Or connect with",
            style = Typography.bodyMedium,
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
    LaunchedEffect(key1 = authViewModel.success.value) {
        if (authViewModel.success.value) {
            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
            navController.navigate(redirectedRoute ?: Router.Profile.route)
        }
    }

    LaunchedEffect(key1 = authViewModel.error.value) {
        if (authViewModel.error.value.isNotEmpty()) {
            Toast.makeText(context, "Error: ${authViewModel.error.value}", Toast.LENGTH_SHORT).show()
        }
    }
    
    LaunchedEffect(key1 = authViewModel.isLoggedIn.value) {
        if (authViewModel.isLoggedIn.value) {
            Toast.makeText(context, "Already logged in", Toast.LENGTH_SHORT).show()
            navController.navigate(Router.Profile.route)
        }
    }

}
