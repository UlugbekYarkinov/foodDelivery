package com.example.fooddelivery

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.fooddelivery.data.BestPriceData

@Composable
fun getFood(label: String): BestPriceData {
    return when(label) {
        stringResource(id = R.string.salad_pesto_pizza_title) -> {
            BestPriceData(
                R.drawable.salad_pesto_pizza,
                title = stringResource(id = R.string.salad_pesto_pizza_title),
                description = stringResource(id = R.string.salad_pesto_pizza_description),
                price = 10.55,
                calorie = 540.0,
                scheduleTime = 20,
                rate = 5.0,
                ingredients = listOf(
                    R.drawable.ing1,
                    R.drawable.ing2,
                    R.drawable.ing3,
                    R.drawable.ing4,
                    R.drawable.ing5,
                )
            )
        }
        stringResource(id = R.string.primavera_pizza_title) -> {
            BestPriceData(
                R.drawable.primavera_pizza,
                title = stringResource(id = R.string.primavera_pizza_title),
                description = stringResource(id = R.string.primavera_pizza_description),
                price = 12.55,
                calorie = 440.0,
                scheduleTime = 30,
                rate = 4.5,
                ingredients = listOf(
                    R.drawable.ing1,
                    R.drawable.ing2,
                    R.drawable.ing3,
                    R.drawable.ing4,
                    R.drawable.ing5,
                )
            )
        }
        stringResource(id = R.string.hamburger_with_cheese_description) -> {
            BestPriceData(
                R.drawable.hamburger_with_cheese,
                title = "Burger & cheese",
                description = stringResource(id = R.string.hamburger_with_cheese_description),
                price = 4.99,
                calorie = 340.0,
                scheduleTime = 10,
                rate = 5.0,
                ingredients = listOf(
                    R.drawable.ing1,
                    R.drawable.ing3,
                    R.drawable.ing5,
                    R.drawable.cheese,
                    R.drawable.meat
                )
            )
        }
        stringResource(id = R.string.hamburger_with_chicken_description) -> {
            BestPriceData(
                R.drawable.hamburger_with_chicken,
                title = "Burger & chicken",
                description = stringResource(id = R.string.hamburger_with_chicken_description),
                price = 3.55,
                calorie = 240.0,
                scheduleTime = 7,
                rate = 4.0,
                ingredients = listOf(
                    R.drawable.ing1,
                    R.drawable.chicken,
                    R.drawable.ing3,
                    R.drawable.cheese,
                    R.drawable.ing5,
                )
            )
        }
        stringResource(id = R.string.ice_tea_description) -> {
            BestPriceData(
                R.drawable.ice_tea,
                title = "Ice tea",
                description = stringResource(id = R.string.ice_tea_description),
                price = 2.49,
                calorie = 40.0,
                scheduleTime = 5,
                rate = 5.0,
                ingredients = listOf(
                    R.drawable.ice,
                    R.drawable.lemon,
                    R.drawable.menta,
                )
            )
        }
        stringResource(id = R.string.mojito_description) -> {
            BestPriceData(
                R.drawable.mahito,
                title = "Mojito",
                description = stringResource(id = R.string.mojito_description),
                price = 3.89,
                calorie = 50.0,
                scheduleTime = 5,
                rate = 4.8,
                ingredients = listOf(
                    R.drawable.ice,
                    R.drawable.lemon,
                    R.drawable.menta,
                )
            )
        }
        else -> {
            BestPriceData(
                R.drawable.mahito,
                title = "Mojito",
                description = stringResource(id = R.string.mojito_description),
                price = 3.89,
                calorie = 50.0,
                scheduleTime = 5,
                rate = 4.8,
                ingredients = listOf(
                    R.drawable.ice,
                    R.drawable.lemon,
                    R.drawable.menta,
                )
            )
        }
    }
}