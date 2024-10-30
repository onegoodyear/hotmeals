package com.example.hotmeals.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotmeals.ui.theme.Typography
import com.example.hotmeals.ui.theme.primaryColor
import com.example.hotmeals.ui.theme.white
import com.example.hotmeals.viewmodels.RegisterViewModel


@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        Text(
            text = "Create your account",
            style = Typography.titleLarge,
            color = primaryColor,
            modifier = Modifier.padding(top = 60.dp)
        )
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = registerViewModel.name.value,
                onValueChange = { registerViewModel.name.value = it },
                label = { Text(text = "Name", color = primaryColor, style = Typography.bodySmall) },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Enter your name", color = primaryColor.copy(0.5f), style = Typography.bodySmall)},
                textStyle = Typography.bodySmall
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = registerViewModel.email.value,
                onValueChange = { registerViewModel.email.value = it },
                label = { Text(text = "Email", color = primaryColor, style = Typography.bodySmall) },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Enter your email", color = primaryColor.copy(0.5f), style = Typography.bodySmall )},
                textStyle = Typography.bodySmall
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = registerViewModel.phone.value,
                onValueChange = { registerViewModel.name.value = it },
                label = { Text(text = "Phone Number", color = primaryColor, style = Typography.bodySmall) },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Enter your phone number", color = primaryColor.copy(0.5f), style = Typography.bodySmall,) },
                textStyle = Typography.bodySmall
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = registerViewModel.password.value,
                onValueChange = { registerViewModel.password.value = it },
                label = { Text(text = "Password", color = primaryColor, style = Typography.bodySmall) },
                placeholder = { Text(text = "Enter a password", color = primaryColor.copy(0.5f), style = Typography.bodySmall ) },
                shape = RoundedCornerShape(12.dp),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = Typography.bodySmall
            )

            Button(

                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = white,
                    containerColor = primaryColor
                ),
                shape = RoundedCornerShape(12.dp),
                onClick = {
                }
            ) {
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    modifier = Modifier.padding(7.dp),
                    style = Typography.bodySmall,
                )
                if (registerViewModel.loading.value) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(7.dp),
                        color = Color.White
                    )
                }

            }
            Text(
                modifier = Modifier
                    .padding(15.dp),
                text = "Already Have an account? sign In",
                style = Typography.bodySmall.copy(fontSize = 16.sp),
                color = primaryColor,

                )
        }
    }
}
