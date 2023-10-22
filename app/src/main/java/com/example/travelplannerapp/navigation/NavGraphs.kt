package com.example.travelplannerapp.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.travelplannerapp.ui.screens.ExploreScreen
import com.example.travelplannerapp.ui.screens.FeedScreen
import com.example.travelplannerapp.ui.screens.HomeScreen
import com.example.travelplannerapp.ui.screens.LoginScreen
import com.example.travelplannerapp.ui.screens.OnboardingScreen
import com.example.travelplannerapp.ui.screens.ProfileScreen
import com.example.travelplannerapp.ui.screens.SignUpScreen


fun NavGraphBuilder.onboardingGraph(navController: NavController){
    navigation(startDestination = "onboarding_screen",
        route = "onboarding"){
        composable(route = "onboarding_screen"){ OnboardingScreen(navController) }
        composable(route = "login_screen"){ LoginScreen(navController = navController) }
        composable(route = "signup_screen"){ SignUpScreen(navController = navController) }
    }

}


fun NavGraphBuilder.homeScreenNavGraph(){
navigation(startDestination = "home_screen",
    route = "home"){
    composable(route = "home_screen"){
        val navController = rememberNavController()
         Scaffold(
             bottomBar = {
                 NavigationBar(containerColor = Color.White,
                     tonalElevation = 8.dp) {
                     val navBackStackEntry by navController.currentBackStackEntryAsState()
                     val currentDestination = navBackStackEntry?.destination
                     bottomNavItems.forEach { screen ->
                         NavigationBarItem(
                             selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true ,
                             onClick = {
                                 navController.navigate(screen.route) {
                                     // Pop up to the start destination of the graph to
                                     // avoid building up a large stack of destinations
                                     // on the back stack as users select items
                                     popUpTo(navController.graph.findStartDestination().id) {
                                         saveState = true
                                     }
                                     // Avoid multiple copies of the same destination when
                                     // reselecting the same item
                                     launchSingleTop = true
                                     // Restore state when reselecting a previously selected item
                                     restoreState = true
                             }
                                       },
                             icon = { Icon(painter = painterResource(id = screen.resourceId), contentDescription = "") },
                             label = {Text(screen.label)},
                             alwaysShowLabel = true)
                     }
                 }
             }
         ) {innerPadding ->
             NavHost(navController = navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
                 composable(Screen.Home.route) { HomeScreen(navController) }
                 composable(Screen.Explore.route){ ExploreScreen(navController =navController)}
                 composable(Screen.Feeds.route){ FeedScreen(navController = navController)}
                 composable(Screen.Profile.route){ ProfileScreen(navController = navController)}
             }
         }
    }
}
}