package com.scottandrews.features.tabbar2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.scottandrews.tabbar.R

@Composable
fun TabBar(navController: NavController) {
    NavigationBar() {
        NavigationBarItem(
            onClick = {
                navController.navigate("HOME")
            },
            selected = true,
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "Localized description")
            }, label = {
                Text(text = "Home")
            }
        )
        NavigationBarItem(
            onClick = {
                navController.navigate("COURSES_PLAYED")
            },
            selected = false,
            icon = {
                Icon(Icons.Filled.Done, contentDescription = "Localized description")
            }, label = {
                Text(text = "Log")
            }
        )
        NavigationBarItem(
            onClick = {
                navController.navigate("COURSES_PLAYED")
            },
            selected = false,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.monitoring_24px),
                    contentDescription = "Localized description"
                )
            }, label = {
                Text(text = "Progress")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TabBar(rememberNavController())
}