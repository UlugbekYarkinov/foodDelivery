@file:Suppress("DEPRECATION")

package com.example.fooddelivery

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenScaffold(navController: NavController) {
    val scrollState = rememberScrollState()

    Scaffold(

        topBar = {
            // App bar content
            Box(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)) {
                Header()
            }
        },
        content = {
            // Body content
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 60.dp, end = 17.dp)
                .verticalScroll(state = scrollState)) {
                OrderNowBox()

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
                        CategoryData(
                            redId = R.drawable.pizza,
                            title = "Pizza"
                        ),
                        CategoryData(redId = R.drawable.hamburger, title = "Burger"),
                        CategoryData(redId = R.drawable.drinks, title = "Drinks")
                    )
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

                BestPriceList(
                    bestPriceList = listOf(
                        BestPriceData(
                            R.drawable.salad_pesto_pizza,
                            title = "Salad Pesto Pizza",
                            description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
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
                        ),
                        BestPriceData(
                            R.drawable.primavera_pizza,
                            title = "Primavera Pizza",
                            description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
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
                    ),
                    navController = navController
                )
            }
        },
    )
}

//Use it in case Scaffold does not work
//@Composable
//fun HomeScreen(navController: NavController) {
//    val scrollState = rememberScrollState()
//
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .padding(start = 30.dp, top = 48.dp, end = 17.dp)
//    ) {
//        Column(modifier = Modifier.verticalScroll(state = scrollState)) {
//            Header()
//
//            Spacer(modifier = Modifier.height(32.dp))
//
//            OrderNowBox()
//
//            Spacer(modifier = Modifier.height(30.dp))
//
//            Text(
//                text = "Categories",
//                style = Typography.bodyLarge,
//                fontSize = 22.sp,
//                color = BlackTextColor
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            CategoryList(
//                categories = listOf(
//                    CategoryData(
//                        redId = R.drawable.pizza,
//                        title = "Pizza"
//                    ), //must be taken from database
//                    CategoryData(redId = R.drawable.hamburger, title = "Burger"),
//                    CategoryData(redId = R.drawable.drinks, title = "Drinks")
//                )
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Text(
//                text = "Best Price",
//                style = Typography.bodyLarge,
//                fontSize = 22.sp,
//                color = BlackTextColor
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            BestPriceList(bestPriceList = listOf(
//                BestPriceData(
//                    R.drawable.salad_pesto_pizza,
//                    title = "Salad Pesto Pizza",
//                    description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
//                    price = 10.55,
//                    calorie = 540.0,
//                    scheduleTime = 20,
//                    rate = 5.0,
//                    ingredients = listOf(
//                        R.drawable.ing1,
//                        R.drawable.ing2,
//                        R.drawable.ing3,
//                        R.drawable.ing4,
//                        R.drawable.ing5,
//                    )
//                ),
//                BestPriceData(
//                    R.drawable.primavera_pizza,
//                    title = "Primavera Pizza",
//                    description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
//                    price = 12.55,
//                    calorie = 440.0,
//                    scheduleTime = 30,
//                    rate = 4.5,
//                    ingredients = listOf(
//                        R.drawable.ing1,
//                        R.drawable.ing2,
//                        R.drawable.ing3,
//                        R.drawable.ing4,
//                        R.drawable.ing5,
//                    )
//                )
//            ), navController = navController)
//        }
//    }
//}

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

@Composable
fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ) {
        BoxWithRes(
            resId = R.drawable.menu,
            bgColor = Yellow500,
            description = "Menu"
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Location",
                modifier = Modifier.size(16.dp),
                tint = Orange500
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "California, US")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "Location",
                modifier = Modifier.size(16.dp),
                tint = Orange500
            )
        }
        BoxWithRes(
            resId = R.drawable.search,
            description = "Search"
        )
    }
}

@Composable
fun OrderNowBox() {
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
                painter = painterResource(id = R.drawable.man),
                contentDescription = "Man",
                modifier = Modifier.size(156.dp))
        }
    }
}

@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = CardItemBg,
    iconColor: Color? = IconColor,
    boxSize: Int? = 40,
    iconSize: Int = 24,
    onButtonClick: (() -> Unit)? = null
    ) {
        Box(
            modifier = Modifier
                .size(boxSize!!.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(bgColor!!)
                .clickable {
                    onButtonClick?.invoke()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = resId),
                contentDescription = description,
                modifier = Modifier
                    .size(iconSize.dp),
                tint = iconColor!!
            )
        }
}

@Composable
fun CategoryList(categories: List<CategoryData>) {

    val selectedIndex = remember {
        mutableStateOf(0)
    }

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
fun CategoryItem(categoryData: CategoryData, selectedIndex: MutableState<Int>, index: Int) {
    Box(
        modifier = Modifier
            .size(width = 106.dp, height = 146.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                selectedIndex.value = index
            }
            .background(
                if (selectedIndex.value == index) Yellow500 else CardItemBg
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = categoryData.redId),
                contentDescription = categoryData.title,
                modifier = Modifier.size(48.dp),
                tint = if(selectedIndex.value == index) Color.White else BlackTextColor
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = categoryData.title,
                style = Typography.bodyLarge,
                fontSize = 18.sp,
                color = if(selectedIndex.value == index) Color.White else BlackTextColor
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodDeliveryTheme {
        val navController = rememberNavController()
        HomeScreenScaffold(navController = navController)
    }
}