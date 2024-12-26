package com.example.hotmeals.views.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotmeals.R
import com.example.hotmeals.ui.theme.primaryColor
import com.example.hotmeals.ui.theme.secondaryColor
import com.example.hotmeals.views.router.Router

@Composable
fun ProfileScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = "Profile",
                style = MaterialTheme.typography.h5,
            )
        }
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.mohamed),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Text(text = "Mohamed", style = MaterialTheme.typography.h6)
            Text(text = "mohamed@gmail.com", style = MaterialTheme.typography.body1)
        }

        Divider(
            modifier = Modifier
                .padding(
                    20.dp,
                ),
            color = primaryColor
        )

        Column {
            ProfileItem(title = "Edit Profile", icon = R.drawable.profile_outline) {
                navController.navigate(Router.Home.route)
            }
            ProfileItem(title = "Payment", icon = R.drawable.wallet_outline) {
            }
            ProfileItem(title = "Security", icon = R.drawable.shield_tick_outline) {
                navController.navigate(Router.Home.route)
            }
            ProfileItem(title = "Notifications", icon = R.drawable.notification_outline) {
                navController.navigate(Router.Home.route)
            }
            ProfileItem(title = "Themes", icon = R.drawable.show_outline) {
                navController.navigate(Router.Home.route)
            }
            ProfileItem(title = "Help", icon = R.drawable.info_square_outline) {
            }
            ProfileItem(title = "Logout", icon = R.drawable.logout_outline, color = Color.Red) {
            }
        }
    }
}




@Composable
fun ProfileItem(
    title: String,
    icon: Int,
    color: Color = (isSystemInDarkTheme()?.let { Color.White } ?: Color.Black),
    onClick: () -> Unit,
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier.size(32.dp),
            colorFilter = ColorFilter.tint(color),
        )
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = color,
        )
    }
}