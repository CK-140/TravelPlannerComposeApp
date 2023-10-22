package com.example.travelplannerapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.travelplannerapp.R

sealed class Screen(val route: String, @DrawableRes val resourceId: Int, val label: String) {
    object Home : Screen("home_screen", R.drawable.iv_calendar_icon,"Home")
    object Explore : Screen("explore_screen", R.drawable.iv_explore_icon, "Explore")

    object Feeds : Screen("feeds_screen", R.drawable.iv_feeds_icon, "Feeds")
    object Profile : Screen("profile_screen", R.drawable.iv_profile_icon, "Profile")
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Explore,
    Screen.Feeds,
    Screen.Profile
)