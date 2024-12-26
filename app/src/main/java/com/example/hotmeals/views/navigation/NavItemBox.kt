package com.example.hotmeals.views.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hotmeals.ui.theme.primaryColor

@Composable
fun NavItemBox(
    navItem: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val contentColor = if (isSelected) primaryColor else if (isSystemInDarkTheme()) Color.White else Color.Black
    val iconSize = if (isSelected) 32.dp else 28.dp
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            imageVector = navItem.icon,
            contentDescription = navItem.title,
            tint = contentColor,
            modifier = Modifier
                .size(iconSize) // Slightly smaller icon
                .background(
                    color = Color.Transparent,
                    shape = CircleShape
                )
                .padding(2.dp) // Reduce padding
        )
    }
}
