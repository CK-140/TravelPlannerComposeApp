package com.example.travelplannerapp.navigation

sealed class OnboardingScreens(val route: String) {
    object OnBoardingScreen: OnboardingScreens("onboarding_screen")
    object LoginScreen: OnboardingScreens("login_screen")
}
