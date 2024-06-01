package com.example.restaurantapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantapp.Restaurant

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    restaurants: List<Restaurant>,
    itemIndex: Int?
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        val restaurant = restaurants[itemIndex!!]
        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = restaurant.imageResourceId),
                contentDescription = stringResource(id = restaurant.name),
                modifier = modifier.clip(RoundedCornerShape(19.dp))
            )
        }
        Text(
            text = stringResource(id = restaurant.name),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn {
            items(1) {
                Text(text = stringResource(id = restaurant.description), fontSize = 20.sp, textAlign = TextAlign.Justify)
            }
        }
    }
}
