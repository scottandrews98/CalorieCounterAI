package com.scottandrews.caloriecounterai.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.scottandrews.caloriecounterai.screens.CoursesPlayedScreen
import com.scottandrews.caloriecounterai.screens.HomeScreen
import com.scottandrews.clubs.individualView.IndivdualClubsViewRoot

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.CoursesPlayed.route) {
            CoursesPlayedScreen(navController)
        }
        composable(
            "${NavigationItem.IndividualClubs.route}/{clubId}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(durationMillis = 300)
                )
            }) { backStackEntry ->
            val clubId = backStackEntry.arguments?.getString("clubId") ?: ""
            IndivdualClubsViewRoot(selectedClub = clubId)
        }
    }
}