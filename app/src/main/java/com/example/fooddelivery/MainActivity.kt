package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.fooddelivery.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    ) {
        Column {
            Header()

            Spacer(modifier = Modifier.height(32.dp))

            OrderNowBox()
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
    iconSize: Int = 24) {
        Box(
            modifier = Modifier
                .size(boxSize!!.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(bgColor!!),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodDeliveryTheme {
        HomeScreen()
    }
}