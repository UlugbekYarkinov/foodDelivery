package com.example.fooddelivery.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R

// Set of Material typography styles to start with
val fonts = FontFamily(
        fonts = listOf(
                Font(R.font.popins_regular, style = FontStyle.Normal),
                Font(R.font.poppins_medium, style = FontStyle.Normal, weight = FontWeight.Medium),
                Font(R.font.poppins_semibold, style = FontStyle.Normal, weight = FontWeight.SemiBold),
        )
)

val Typography = Typography(
        displayLarge = TextStyle(
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
        ),
        displayMedium = TextStyle(
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 26.sp,
        ),
        displaySmall = TextStyle(
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
        ),
        bodyLarge = TextStyle(
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),
        bodyMedium = TextStyle(
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),
        titleLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        ),
        labelSmall = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
        )

)