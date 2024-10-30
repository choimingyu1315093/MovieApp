package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies") },
                colors = TopAppBarDefaults.topAppBarColors(Color.LightGray),
            )
        },
        modifier = Modifier
            .statusBarsPadding()
            .safeDrawingPadding()
    ){ innerPadding ->
        MainContent(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}

@Composable
fun MainContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    movieList: List<Movie> = getMovies(),
    innerPadding: PaddingValues
){
    LazyColumn (
        modifier = modifier
            .padding(innerPadding)
            .padding(12.dp)
    ){
        items(items = movieList){item ->
            MovieRow(item, { movie ->
                navController.navigate(route = MovieScreens.DetailScreen.name+"/$movie")
            })
        }
    }
}