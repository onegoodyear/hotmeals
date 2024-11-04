package com.example.hotmeals.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hotmeals.ui.theme.primaryColor
import com.example.hotmeals.ui.theme.white
import com.example.hotmeals.R
import com.example.hotmeals.ui.theme.Typography

@Composable
fun GetStartedScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround, // Space between items
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tacos),
                contentDescription = "Tacos",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(300.dp)
            )
            Text(
                style = Typography.bodyLarge,
                text = "Enjoy your meals",
                color = white,
                fontWeight = FontWeight.Bold, // Set font weight to bold
            )
        }

        // Bottom Section: Button
        Button(

            onClick = {
                navController.navigate("login")
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(horizontal = 48.dp, vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = primaryColor,
                containerColor = white,
            )

        ) {
            Text(style = Typography.bodyMedium,text = "Get Started", fontWeight = FontWeight.Bold)
        }
    }
}
