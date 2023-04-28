package com.example.fooddelivery.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fooddelivery.*
import com.example.fooddelivery.R
import com.example.fooddelivery.data.BestPriceData
import com.example.fooddelivery.data.CategoryData
import com.example.fooddelivery.ui.theme.*
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenScaffold(navController: NavController) {
    val scrollState = rememberScrollState()
    val selectedIndex = viewModel<HomeScreenViewModel>()

    Scaffold(

        topBar = {
            // App bar content
            Box(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)) {
                Header(navController)
            }
        },
        content = {
            // Body content
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 60.dp, end = 17.dp)
                .verticalScroll(state = scrollState)) {
                OrderNowBox(navController)

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Categories",
                    style = Typography.bodyLarge,
                    fontSize = 22.sp,
                    color = BlackTextColor,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                CategoryList(
                    categories = listOf(
                        CategoryData(redId = R.drawable.pizza, title = "Pizza"),
                        CategoryData(redId = R.drawable.hamburger, title = "Burger"),
                        CategoryData(redId = R.drawable.drinks, title = "Drinks")
                    ),
                    selectedIndex
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Best Price",
                    style = Typography.bodyLarge,
                    fontSize = 22.sp,
                    color = BlackTextColor,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                BestPriceCategory(selectedIndex = selectedIndex, navController = navController)
            }
        },
    )
}

@Composable
fun Header(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ) {
        BoxWithRes(
            resId = R.drawable.logout,
            bgColor = Yellow500,
            description = "Menu",
            onButtonClick = {
                FirebaseAuth.getInstance().signOut()
                navController.popBackStack()
            }
        )
        Text(
            text = "FOOD DELIVERY",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
        BoxWithRes(
            resId = R.drawable.search,
            description = "Search"
        )
    }
}

@Composable
fun OrderNowBox(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Yellow200)
            .padding(24.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(color = BlackTextColor)) {
                        append("The Fastest In\n" + "Delivery")
                    }
                    withStyle(style = SpanStyle(color = Yellow500)) {
                        append("Food")
                    }
                })
                Box(
                    modifier = Modifier
                        .size(width = 126.dp, height = 40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { navController.navigate(Destinations.AllFood) }
                        .background(Yellow500),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Order Now",
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.food_delivery),
                contentDescription = "food delivery",
                modifier = Modifier.size(156.dp))
        }
    }
}

@Composable
fun CategoryList(categories: List<CategoryData>, selectedIndex: HomeScreenViewModel) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        items(categories.size) {
                index ->  CategoryItem(
            categoryData = categories[index],
            selectedIndex = selectedIndex,
            index = index
        )
        }
    }
}
@Composable
fun CategoryItem(categoryData: CategoryData, selectedIndex: HomeScreenViewModel, index: Int) {
    Box(
        modifier = Modifier
            .size(width = 106.dp, height = 146.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                selectedIndex.updateSelectedIndex(index)
            }
            .background(
                if (selectedIndex.getSelectedIndex() == index) Yellow500 else CardItemBg
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = categoryData.redId),
                contentDescription = categoryData.title,
                modifier = Modifier.size(48.dp),
                tint = if(selectedIndex.getSelectedIndex() == index) Color.White else BlackTextColor
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = categoryData.title,
                style = Typography.bodyLarge,
                fontSize = 18.sp,
                color = if(selectedIndex.getSelectedIndex() == index) Color.White else BlackTextColor
            )
        }
    }
}

@Composable
fun BestPriceCategory(selectedIndex: HomeScreenViewModel, navController: NavController) {
    when(selectedIndex.getSelectedIndex()) {
        0 -> {
            BestPriceList(
                bestPriceList = listOf(
                    getFood(label = stringResource(id = R.string.salad_pesto_pizza_title)),
                    getFood(label = stringResource(id = R.string.primavera_pizza_title))
                ),
                navController = navController
            )
        }
        1 -> {
            BestPriceList(
                bestPriceList = listOf(
                    getFood(label = stringResource(id = R.string.hamburger_with_cheese_description)),
                    getFood(label = stringResource(id = R.string.hamburger_with_chicken_description))
                ),
                navController = navController
            )
        }

        2 -> {
            BestPriceList(
                bestPriceList = listOf(
                    getFood(label = stringResource(id = R.string.ice_tea_description)),
                    getFood(label = stringResource(id = R.string.mojito_description))
                ),
                navController = navController
            )
        }
    }
}

@Composable
fun BestPriceList(bestPriceList: List<BestPriceData>, navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        for(item in bestPriceList) {
            BestPriceItem(bestPriceData = item, navController = navController)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
@Composable
fun BestPriceItem(bestPriceData: BestPriceData, navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(176.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(176.dp)
                .padding(end = 13.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    navController.currentBackStackEntry?.arguments = Bundle().apply {
                        putParcelable(Destinations.DetailArgs.foodData, bestPriceData)
                    }
                    navController.navigate(Destinations.Detail)
                }
                .background(CardItemBg))

        Column(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
            Box(
                modifier = Modifier.height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.crown),
                        contentDescription = "Crown",
                        modifier = Modifier.size(34.dp)
                    )

                    Spacer(modifier = Modifier.width(11.dp))

                    Text(
                        text = "Best Selling",
                        style = Typography.displaySmall,
                        fontSize = 14.sp,
                        color = TextColor
                    )
                }
            }

            Box(
                modifier = Modifier.height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = bestPriceData.title,
                    style = Typography.bodyLarge,
                    fontSize = 18.sp,
                    color = BlackTextColor
                )
            }

            Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$",
                        style = Typography.bodyLarge,
                        fontSize = 14.sp,
                        color = Orange500
                    )

                    Text(
                        text = "${bestPriceData.price}",
                        style = Typography.bodyLarge,
                        fontSize = 20.sp,
                        color = BlackTextColor
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(width = 60.dp, height = 40.dp)
                        .clip(RoundedCornerShape(bottomStart = 10.dp, topEnd = 18.dp))
                        .background(Yellow500),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "Add",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Star",
                        modifier = Modifier.size(16.dp),
                        tint = BlackTextColor
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = "${bestPriceData.rate}", style = Typography.bodyLarge, color = BlackTextColor)
                }
            }
        }

        Image(
            painter = painterResource(id = bestPriceData.resId),
            contentDescription = "",
            modifier = Modifier
                .size(156.dp)
                .align(
                    Alignment.CenterEnd
                )
        )
    }
}