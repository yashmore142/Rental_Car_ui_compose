package com.example.rental_car_ui_compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rental_car_ui_compose.R
import com.example.rental_car_ui_compose.ui.theme.Primary
import com.example.rental_car_ui_compose.ui.theme.Rental_Car_Ui_ComposeTheme


@Composable
fun CarItem(
    modifier: Modifier = Modifier,
    car: Car
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(car.bgColor)
    ) {
        Image(
            painter = painterResource(car.image),
            contentDescription = car.name,
            modifier = Modifier.offset(x = 150.dp, y = 0.dp)
        )

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CarInfo(car = car)
                Spacer(modifier = Modifier.height(20.dp))
                Rating(car = car)
            }

            BuyButton(car = car)
        }
    }
}

@Composable
fun BuyButton(modifier: Modifier = Modifier, car: Car) {
    Row(modifier = modifier
        .padding(start = 10.dp, bottom = 10.dp)
        .clip(RoundedCornerShape(40.dp))
        .background(MaterialTheme.colorScheme.surfaceVariant)
        .padding(horizontal = 16.dp, vertical = 10.dp)
    , verticalAlignment = Alignment.CenterVertically) {
        Column {
            Text(text = "${car.rentalDays} Days",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.8f))
            Text(text = "$${car.price}.00",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.8f),
                fontWeight = FontWeight.SemiBold)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Icon(imageVector = Icons.Rounded.ArrowForward, contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground.copy(0.8f),
            modifier = Modifier.size(30.dp))
    }
}

@Composable
fun Rating(modifier: Modifier = Modifier, car: Car) {

    Column(
        modifier = modifier.padding(start = 20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box {
                Rater(image = car.recommenders[0])
                Rater(modifier = Modifier.padding(start = 24.dp), image = car.recommenders[1])
                Rater(modifier = Modifier.padding(start = 48.dp), image = car.recommenders[2])
            }

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "${car.recommendationRate}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(0.8f)
            )
        }
        Text(
            text = "${car.recommendation} % Recommended",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black.copy(0.8f)
        )
    }

}

@Composable
fun Rater(
    modifier: Modifier = Modifier,
    image: Int
) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier
            .size(30.dp)
            .clip(CircleShape)
            .border(
                color = Color.Black,
                width = 2.dp,
                shape = CircleShape
            )
    )

}

@Composable
fun CarInfo(
    modifier: Modifier = Modifier,
    car: Car
) {
    Row(
        modifier = Modifier.padding(top = 20.dp, start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(car.logo),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.background)
                .padding(6.dp)
                .size(35.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Color : ",
                    fontSize = 12.sp,
                    color = Color.Black.copy(0.8f)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(car.bgColor)
                        .border(
                            color = Color.Black,
                            width = 1.dp,
                            shape = CircleShape
                        )
                )
            }
            Text(
                text = car.name,
                fontSize = 12.sp,
                color = Color.Black.copy(0.8f),
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}

@Preview
@Composable
private fun HomeCareItemPreview() {

    Rental_Car_Ui_ComposeTheme {
        CarItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp),
            Car(
                name = "Ferrari SF90 Stradale",
                image = R.drawable.ferrari_car,
                color = Color.Red,
                logo = R.drawable.ferrari_logo,
                recommendation = 97,
                recommendationRate = 4.8f,
                rentalDays = 7,
                price = 759,
                recommenders = listOf(
                    R.drawable.m_2, R.drawable.w_1, R.drawable.m_1
                ),
                bgColor = Primary
            )
        )
    }
}