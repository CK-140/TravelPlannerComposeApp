package com.example.travelplannerapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelplannerapp.ui.screens.LoginScreen
import com.example.travelplannerapp.ui.screens.OnboardingScreen
import com.example.travelplannerapp.ui.screens.SignUpScreen
import com.example.travelplannerapp.ui.theme.TravelPlannerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            TravelPlannerAppTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = "onboarding_screen"){
                        composable("onboarding_screen"){ OnboardingScreen(navController)}
                        composable(route = "login_screen"){ LoginScreen(navController = navController)}
                        composable(route = "signup_screen"){ SignUpScreen(navController = navController)}
                    }
                }
            }
        }
    }

}
