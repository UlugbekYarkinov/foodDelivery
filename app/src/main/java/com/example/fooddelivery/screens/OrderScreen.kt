package com.example.fooddelivery.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.components.getFood
import com.example.fooddelivery.data.BestPriceData
import com.example.fooddelivery.screens.viewmodels.OrderViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navController: NavController, orderViewModel: OrderViewModel) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 60.dp, end = 17.dp)
                    .verticalScroll(state = scrollState)
            ) {
                BestPriceList(
                    bestPriceList = orderFoodList(foodLabelList = orderViewModel.getFoodLabelList()),
                    navController = navController
                )
            }
        },
    )
}

@Composable
fun orderFoodList(foodLabelList: MutableList<String>): List<BestPriceData> {
    val foodList = mutableListOf<BestPriceData>()


    for (foodLabel in foodLabelList) {
        foodList.add(getFood(label = foodLabel))
    }

    return foodList.toList()
}