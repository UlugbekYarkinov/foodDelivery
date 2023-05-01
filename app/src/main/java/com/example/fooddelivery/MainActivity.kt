package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.screens.*
import com.example.fooddelivery.screens.authentication.LoginScreen
import com.example.fooddelivery.screens.authentication.RegistrationScreen
import com.example.fooddelivery.screens.viewmodels.OrderViewModel
import com.example.fooddelivery.ui.theme.*

object Destinations {
    const val Home = "Home"
    const val Detail = "Detail"
    const val AllFood = "AllFood"
    const val LogIn = "LogIn"
    const val Register = "Register"
    const val OrderList = "OrderList"

    const val firebaseDatabaseUrl =
        "https://fooddelivery-fafbe-default-rtdb.asia-southeast1.firebasedatabase.app"

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
                val orderViewModel = viewModel<OrderViewModel>()

                NavHost(
                    navController = navController,
                    startDestination = Destinations.LogIn,
                    builder = {
                        composable(Destinations.LogIn) {
                            LoginScreen(
                                navController = navController,
                                orderListViewModel = orderViewModel
                            )
                        }
                        composable(Destinations.Register) {
                            RegistrationScreen(navController = navController)
                        }
                        composable(Destinations.Home) {
                            HomeScreenScaffold(navController = navController)
                        }
                        composable(Destinations.Detail) {
                            DetailScreenScaffold(
                                navController = navController,
                                orderViewModel = orderViewModel
                            )
                        }
                        composable(Destinations.AllFood) {
                            AllFoodScreenScaffold(navController = navController)
                        }
                        composable(Destinations.OrderList) {
                            OrderScreen(
                                navController = navController,
                                orderViewModel = orderViewModel
                            )
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