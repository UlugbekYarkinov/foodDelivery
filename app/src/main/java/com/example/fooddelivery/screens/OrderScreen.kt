package com.example.fooddelivery.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.components.getFood
import com.example.fooddelivery.data.BestPriceData
import com.example.fooddelivery.screens.viewmodels.OrderViewModel
import com.example.fooddelivery.ui.theme.CardItemBg

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navController: NavController, orderViewModel: OrderViewModel) {
    val scrollState = rememberScrollState()
    val orderListState = remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        // App bar content
        Box(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)) {
            DetailHeader(navController)
        }
    }, content = {
        // Body content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 60.dp, end = 17.dp)
                .verticalScroll(state = scrollState)
        ) {
            if (orderListState.value) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(CardItemBg)
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "You Cart is Empty :)")
                }
            } else {
                BestPriceList(
                    bestPriceList = orderFoodList(foodLabelList = orderViewModel.getFoodLabelList()),
                    navController = navController
                )
            }
        }
    }, floatingActionButton = {
        // FAB content
        FloatingActionButton(
            onClick = {
                // set up user DB reference
                // TODO: Users must be added to database while registering, now only testuser@email.com is registered
                // TODO: Also note that all special chars like @ or . in emails should be replaced with _ and - accordingly
                val userDB = orderViewModel.getDBRef()?.getReference(
                    "users/${
                        orderViewModel.getUserEmail().replace("@", "_").replace(".", "-")
                    }/orders"
                )
                // set up new order
                // upload order
                userDB?.push()?.setValue(orderViewModel.getFoodLabelList())
                // clear the cart
                orderViewModel.clearList()
                orderListState.value = true;
            }, modifier = Modifier.padding(16.dp), containerColor = Color(0xFFFDC913)
        ) {
            Icon(Icons.Default.ThumbUp, contentDescription = "Add")
        }
    })
}

@Composable
fun orderFoodList(foodLabelList: MutableList<String>): List<BestPriceData> {
    val foodList = mutableListOf<BestPriceData>()


    for (foodLabel in foodLabelList) {
        foodList.add(getFood(label = foodLabel))
    }

    return foodList.toList()
}