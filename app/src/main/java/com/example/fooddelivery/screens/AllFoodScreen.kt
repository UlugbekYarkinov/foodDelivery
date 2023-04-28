package com.example.fooddelivery.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.getFood

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllFoodScreenScaffold(navController: NavController) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            // App bar content
            Box(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)) {
                DetailHeader(navController)
            }
        },
        content = {
            // Body content
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 60.dp, end = 17.dp)
                .verticalScroll(state = scrollState)
            ) {
                BestPriceList(
                    bestPriceList = listOf(
                        getFood(label = stringResource(id = R.string.salad_pesto_pizza_title)),
                        getFood(label = stringResource(id = R.string.primavera_pizza_title)),
                        getFood(label = stringResource(id = R.string.hamburger_with_cheese_description)),
                        getFood(label = stringResource(id = R.string.hamburger_with_chicken_description)),
                        getFood(label = stringResource(id = R.string.ice_tea_description)),
                        getFood(label = stringResource(id = R.string.mojito_description))
                    ),
                    navController = navController
                )
            }
        },
    )
}