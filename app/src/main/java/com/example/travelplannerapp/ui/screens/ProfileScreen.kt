package com.example.travelplannerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Surface(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
            Text(text = "fdaaaaa")
        }

    }

}