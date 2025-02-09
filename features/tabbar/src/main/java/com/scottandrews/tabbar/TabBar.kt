package com.scottandrews.tabbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TabBar(navController: NavController) {

    val selectedItem = rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        NavigationBarItem(
            onClick = {
                selectedItem.intValue = 0
                navController.navigate("HOME")
            },
            selected = selectedItem.intValue == 0,
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "Localized description")
            }, label = {
                Text(text = "Home")
            }
        )
        NavigationBarItem(
            onClick = {
                selectedItem.intValue = 1
                navController.navigate("COURSES_PLAYED")
            },
            selected = selectedItem.intValue == 1,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.stylus_24px),
                    contentDescription = "Localized description"
                )
            }, label = {
                Text(text = "Log")
            }
        )
        NavigationBarItem(
            onClick = {
                selectedItem.intValue = 2
                navController.navigate("COURSES_PLAYED")
            },
            selected = selectedItem.intValue == 2,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.monitoring_24px),
                    contentDescription = "Localized description"
                )
            }, label = {
                Text(text = "Progress")
            }
        )
        NavigationBarItem(
            onClick = {
                selectedItem.intValue = 3
                navController.navigate("COURSES_PLAYED")
            },
            selected = selectedItem.intValue == 3,
            icon = {
                Icon(Icons.Filled.Person, contentDescription = "Localized description")
            }, label = {
                Text(text = "Profile")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TabBar(rememberNavController())
}