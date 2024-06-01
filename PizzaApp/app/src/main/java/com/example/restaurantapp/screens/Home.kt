package com.example.restaurantapp.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.restaurantapp.Restaurant
import com.example.pizzaapp.R
import com.example.restaurantapp.restaurants
import com.example.compose.RestaurantAppTheme

@Composable
fun HomeScreen(
    restaurants: List<Restaurant>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = { PizzaAppTopBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            val itemCount = restaurants.size

            items(itemCount) {index ->
                val restaurant = restaurants[index]
                ColumnItem(
                    modifier,
                    restaurant = restaurant,
                    itemIndex = index,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    restaurant: Restaurant,
    itemIndex: Int,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = Pantalla.Detail.name + "/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = restaurant.imageResourceId),
                contentDescription = stringResource(id = restaurant.name),
                modifier = modifier.size(dimensionResource(id = R.dimen.image_siza))
            )
            Column(modifier.padding(12.dp)) {
                Text(text = stringResource(id = restaurant.name), fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = restaurant.preview), fontSize = 18.sp)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaAppTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
    )
}

enum class Pantalla(@StringRes nombre: Int){
    Home(R.string.Home),
    Detail(R.string.Detail)
}

@Composable
@Preview
fun previewPizza(){
    RestaurantAppTheme(){
        HomeScreen( restaurants, rememberNavController())
    }
}