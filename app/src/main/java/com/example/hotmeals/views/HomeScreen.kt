package com.example.hotmeals.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotmeals.ui.theme.Typography
import com.example.hotmeals.ui.theme.primaryColor
import com.example.hotmeals.R
import com.example.hotmeals.ui.theme.secondaryColor
import com.example.hotmeals.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val textColor = if (isSystemInDarkTheme()) white else primaryColor
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //title and profile picture
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "HotMeals",
                style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold), // Adjust text style as needed
                color = textColor,
            )
            Image(
                painter = painterResource(id = R.drawable.mohamed), // Replace with your actual image resource
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, textColor, CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        // Search Bar
        TextField(
            value = "",
            onValueChange = { /*TODO*/ },
            placeholder = {
                Text(
                    text = "Search...",
                    color = primaryColor.copy(0.5f),
                    style = Typography.bodySmall,
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Red,
                )
            },
            modifier = Modifier.fillMaxWidth().height(48.dp),
            textStyle = Typography.bodyMedium,
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = secondaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = primaryColor,
            )
        )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Title: Discover or New
                Text(
                    text = "Discover",  // Change to "New" if you prefer
                    style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = primaryColor,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // New items section with LazyRow
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(30) { index ->
                        // Repeat items 30 times
                        Box(
                            modifier = Modifier
                                .width(76.dp)
                                .height(76.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (index % 2 == 0) primaryColor else secondaryColor) // Alternate colors for variety
                        ) {
                            Image(
                                painter = painterResource(
                                    id = when (index % 3) { // Change images based on index
                                        0 -> R.drawable.pizza
                                        1 -> R.drawable.tacos
                                        else -> R.drawable.vajitas
                                    }
                                ),
                                contentDescription = "Food Item",
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }

    }
}