package com.example.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.RestaurantAppTheme
import com.example.restaurantapp.screens.DetailScreen
import com.example.restaurantapp.screens.HomeScreen
import com.example.restaurantapp.screens.Pantalla


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantAppTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Pantalla.Home.name) {
                        composable(route = Pantalla.Home.name) {
                            HomeScreen(restaurants, navController)
                        }
                        composable(route = Pantalla.Detail.name + "/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index ->
                            DetailScreen(
                                restaurants = restaurants,
                                itemIndex = index.arguments?.getInt("index")
                            )
                        }
                    }

                }
            }
        }


    }
}
@Composable
@Preview
fun previewPizza(){
    RestaurantAppTheme(){
        HomeScreen(restaurants, rememberNavController())
    }
}
