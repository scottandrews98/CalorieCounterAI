package com.scottandrews.caloriecounterai.navigation

enum class Screen {
    HOME,
    COURSES_PLAYED,
    INDIVIDUAL_CLUBS,
}

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object CoursesPlayed : NavigationItem(Screen.COURSES_PLAYED.name)
    object IndividualClubs : NavigationItem(Screen.INDIVIDUAL_CLUBS.name)
}