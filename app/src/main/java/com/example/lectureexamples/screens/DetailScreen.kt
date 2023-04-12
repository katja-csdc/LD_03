package com.example.lectureexamples.screens

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.lectureexamples.MovieCard
import com.example.lectureexamples.models.getMovies

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavHostController, movieId: String) {
    val movie = getMovies().first { it.id == movieId }

    Scaffold(
        topBar = { DetailScreenTopBar(navController, movie.title) }
    ) {
        MovieCard(
            navController = navController,
            movie = movie,
            isDetailScreen = true)

        // TODO: add new composable function that show image gallery, e.g. ImageGallery()
    }
}

@Composable
fun DetailScreenTopBar(navController: NavHostController, movieTitle: String) {
    TopAppBar(
        title = { Text(text = movieTitle) },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "More")
            }
        }
    )
}
