package com.scottandrews.caloriecounterai.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.scottandrews.addfood.presentation.AddFoodViewRoot
import com.scottandrews.clubs.ClubsViewRoot
import com.scottandrews.clubs.add.ClubsAddFormView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    // Define a callback to collapse the bottom sheet
    val closeBottomSheet: () -> Unit = {
        scope.launch {
            sheetState.hide()
        }
    }

    val navigateToIndividualClubs: (String) -> Unit = { clubId ->
        navController.navigate("INDIVIDUAL_CLUBS/$clubId")
    }

    Column {
        Text(text = "Home Screen")
        ClubsViewRoot(navigateToClub = navigateToIndividualClubs)

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                ClubsAddFormView(closeBottomSheet)
            }
        }

        Box(
            modifier = Modifier.fillMaxSize() // Occupies the full screen size
        ){
            FloatingActionButton(
                onClick = { showBottomSheet = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Aligns to the bottom-right corner
                    .padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }

        AddFoodViewRoot()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen(rememberNavController())
}