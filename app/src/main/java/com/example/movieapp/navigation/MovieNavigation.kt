package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.detail.DetailScreen
import com.example.movieapp.screens.home.HomeScreen

//Navigation Component >> Nav Controller > Nav Host > Nav Graph
@Composable
fun MovieNavigation(){
    //종속성 추가
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(route = MovieScreens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(
            route = MovieScreens.DetailScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){
            DetailScreen(navController, it.arguments?.getString("movie"))
        }
    }
}