package com.example.fooddelivery

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.ui.theme.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenScaffold(navController: NavController) {
    val scrollState = rememberScrollState()
    var numberOfMeal by remember { mutableStateOf(1) }

    val data = navController.previousBackStackEntry?.arguments?.getParcelable<BestPriceData>(Destinations.DetailArgs.foodData)

    Scaffold(
        topBar = {
            Box(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)) {
                DetailHeader(navController)
            }
        },
        content = {
            if (data != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = scrollState)
                        .padding(start = 30.dp, top = 48.dp, end = 17.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = data.resId),
                        contentDescription = "",
                        modifier = Modifier.size(275.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.SpaceBetween) {
                            Text(
                                text = data.title,
                                style = Typography.bodyLarge,
                                fontSize = 23.sp,
                                color = BlackTextColor
                            )

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "$",
                                    style = Typography.bodyLarge,
                                    fontSize = 20.sp,
                                    color = Orange500
                                )

                                Text(
                                    text = "${data.price}",
                                    style = Typography.bodyLarge,
                                    fontSize = 28.sp,
                                    color = BlackTextColor
                                )
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.size(width = 130.dp, height = 36.dp)
                        ) {
                            BoxWithRes(
                                resId = R.drawable.minus,
                                description = "Minus",
                                boxSize = 36,
                                iconColor = BlackTextColor,
                                onButtonClick = {
                                    if (numberOfMeal > 1) {
                                        numberOfMeal--
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.width(14.dp))

                            Text(
                                text = "$numberOfMeal",
                                style = Typography.bodyLarge,
                                fontSize = 28.sp,
                                color = BlackTextColor
                            )

                            Spacer(modifier = Modifier.width(14.dp))

                            BoxWithRes(
                                resId = R.drawable.add,
                                description = "Add",
                                boxSize = 36,
                                iconColor = Color.White,
                                bgColor = Yellow500,
                                onButtonClick = {
                                    numberOfMeal++
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = data.description,
                        style = Typography.bodyLarge,
                        color = TextColor,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailFoodInfoBox(data = data)

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailIngredientsBox(data = data)

                    Spacer(modifier = Modifier.height(10.dp))

//                    Box(
//                        modifier = Modifier
//                            .size(width = 203.dp, height = 56.dp)
//                            .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
//                            .background(Yellow500),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "Add to cart", style = Typography.bodyLarge, color = Color.White)
//                    }
                }
            } else {
                // TODO: design the exception style
            }
        },
        floatingActionButton = {
            // FAB content
            FloatingActionButton(
                onClick = { /* Handle FAB click */ },
                modifier = Modifier.padding(16.dp),
                containerColor =  Color(0xFFFDC913)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    )
}

//Use it in case Scaffold does not work
//@Composable
//fun DetailScreen(navController: NavController) {
//    val scrollState = rememberScrollState()
//    var numberOfMeal = remember {
//        mutableStateOf(1)
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
//    ) {
//        val data = navController.previousBackStackEntry?.arguments?.getParcelable<BestPriceData>(Destinations.DetailArgs.foodData) //need to think to replace deprecated code
//
//        if (data != null) {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.verticalScroll(state = scrollState)
//            ) {
//                DetailHeader(navController)
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                Image(
//                    painter = painterResource(id = data.resId),
//                    contentDescription = "",
//                    modifier = Modifier.size(275.dp)
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(80.dp)
//                ) {
//                    Column(verticalArrangement = Arrangement.SpaceBetween) {
//                        Text(
//                            text = data.title,
//                            style = Typography.bodyLarge,
//                            fontSize = 23.sp,
//                            color = BlackTextColor
//                        )
//
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text(
//                                text = "$",
//                                style = Typography.bodyLarge,
//                                fontSize = 20.sp,
//                                color = Orange500
//                            )
//
//                            Text(
//                                text = "${data.price}",
//                                style = Typography.bodyLarge,
//                                fontSize = 28.sp,
//                                color = BlackTextColor
//                            )
//                        }
//                    }
//
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        BoxWithRes(
//                            resId = R.drawable.minus,
//                            description = "Minus",
//                            boxSize = 36,
//                            iconColor = BlackTextColor
//                        )
//
//                        Spacer(modifier = Modifier.width(14.dp))
//
//                        Text(
//                            text = "${numberOfMeal.value}",
//                            style = Typography.bodyLarge,
//                            fontSize = 28.sp,
//                            color = BlackTextColor
//                        )
//
//                        Spacer(modifier = Modifier.width(14.dp))
//
//                        BoxWithRes(
//                            resId = R.drawable.add,
//                            description = "Add",
//                            boxSize = 36,
//                            iconColor = Color.White,
//                            bgColor = Yellow500
//                        )
//                    }
//                }
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Text(
//                    text = data.description,
//                    style = Typography.bodyLarge,
//                    color = TextColor,
//                    modifier = Modifier.fillMaxWidth()
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                DetailFoodInfoBox(data = data)
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                DetailIngredientsBox(data = data)
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                Box(
//                    modifier = Modifier
//                        .size(width = 203.dp, height = 56.dp)
//                        .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
//                        .background(Yellow500),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "Add to card", style = Typography.bodyLarge, color = Color.White)
//                }
//            }
//        } else {
//            //TODO: design the exception style
//        }
//    }
//}

@Composable
fun DetailHeader(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ) {
        BoxWithRes(
            resId = R.drawable.arrow_left,
            bgColor = Yellow500,
            description = "Left",
            onButtonClick = {
                navController.popBackStack()
            }
        )

        Box(modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(CardItemBg),
            contentAlignment = Alignment.Center) {
            Box(modifier = Modifier.size(24.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.bag),
                    contentDescription = "Basket",
                    modifier = Modifier.size(24.dp),
                    tint = IconColor
                )
                Box(
                    modifier = Modifier
                        .padding(top = 2.dp, end = 2.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.TopEnd)
                ) {
                    Box(modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(Yellow500)) {
                    }
                }
            }
        }
    }
}

@Composable
fun DetailFoodInfoBox(data: BestPriceData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(CardItemBg)
            .padding(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.calori),
                    contentDescription = "Caloric",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "${data.calorie} kcal",
                    style = Typography.bodyLarge,
                    color = BlackTextColor
                )
            }

            Divider(
                color = DividerColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Row {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "${data.rate}",
                    style = Typography.bodyLarge,
                    color = BlackTextColor
                )
            }

            Divider(
                color = DividerColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Row {
                Image(
                    painter = painterResource(id = R.drawable.schedule),
                    contentDescription = "Schedule",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "${data.scheduleTime} min",
                    style = Typography.bodyLarge,
                    color = BlackTextColor
                )
            }
        }
    }
}

@Composable
fun DetailIngredientsBox(data: BestPriceData) {
    Text(
        text = "Ingredients",
        style = Typography.bodyLarge,
        fontSize = 22.sp,
        color = BlackTextColor,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(10.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(data.ingredients.size) {
                index -> Box(modifier = Modifier
            .size(56.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(CardItemBg),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = data.ingredients[index]),
                contentDescription = "",
                modifier = Modifier.size(width = 46.dp, height = 36.dp)
            )
        }
        }
    }
}