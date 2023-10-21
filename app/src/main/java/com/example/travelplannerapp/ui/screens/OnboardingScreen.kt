package com.example.travelplannerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelplannerapp.R
import com.example.travelplannerapp.ui.theme.textOrange

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.ic_onboarding_background),
                contentScale = ContentScale.FillBounds,
                alpha = 0.5f
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 380.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "Travel", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_bold)
                    ), fontSize = 20.sp,
                    color = textOrange
                )

                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "Planner", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_bold)
                    ), fontSize = 20.sp,
                    color = Color.White
                )

            }

            Spacer(modifier = Modifier.height(0.dp))

            Column( modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Text(
                    text = "Hello,wanderlust enthusiast", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_extra_bold)
                    ), fontSize = 32.sp,
                    color = Color.White
                )

                Text(
                    text = "Ready to plan your next adventure? Log in now", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_extra_light)
                    ), fontSize = 14.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(100.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.outlinedButtonColors(textOrange),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {
                              navController.navigate("login_screen")
                    },
                ){
                    Text(text = "Continue", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    ), fontSize = 14.sp,
                        color = Color.White)
                }
            }
        }


    }
}