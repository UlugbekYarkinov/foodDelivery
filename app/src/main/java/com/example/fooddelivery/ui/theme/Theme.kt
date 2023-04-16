package com.example.fooddelivery.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FoodDeliveryTheme(
        content: @Composable () -> Unit
) {
    MaterialTheme(
            typography = Typography,
            content = content
    )
}