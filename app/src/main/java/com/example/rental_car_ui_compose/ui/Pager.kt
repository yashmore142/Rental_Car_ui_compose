package com.example.rental_car_ui_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rental_car_ui_compose.ui.theme.Primary
import dev.chrisbanes.haze.hazeChild
@Preview
@Composable
fun Pager(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Text(
            text = "Luxurious\nRental Cars",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            lineHeight = 40.sp,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Luxurious",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "VIP Cars",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "New",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .alpha(0.7f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Primary)
                        .padding(horizontal = 5.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.onBackground
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}