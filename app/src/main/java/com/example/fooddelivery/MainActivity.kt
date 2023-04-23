@file:Suppress("DEPRECATION")

package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.ui.theme.*

object Destinations {
    const val Home = "Home"
    const val Detail = "Detail"

    object DetailArgs {
        const val foodData = "foodData"
    }
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Destinations.Home, builder = {
                    composable(Destinations.Home) {
                        HomeScreenScaffold(navController = navController)
                    }
                    composable(Destinations.Detail) {
                        DetailScreenScaffold(navController = navController)
                    }
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodDeliveryTheme {
        val navController = rememberNavController()
        HomeScreenScaffold(navController = navController)
    }
}