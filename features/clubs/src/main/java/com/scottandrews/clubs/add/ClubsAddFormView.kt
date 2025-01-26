package com.scottandrews.clubs.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.scottandrews.core.data.ClubsDataRepositoryPreview

@Composable
fun ClubsAddFormView(
    closeBottomSheet: () -> Unit,
    clubsAddFormViewModel: ClubsAddFormViewModel = hiltViewModel()
) {
    clubsAddFormViewModel.onCloseBottomSheet = closeBottomSheet
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        TextField(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 10.dp),
            value = clubsAddFormViewModel.clubName.value,
            singleLine = true,
            onValueChange = { clubsAddFormViewModel.setClubName(it) },
            label = { Text(text = "Enter Your Club Name") },
        )

        TextField(
            value = clubsAddFormViewModel.clubDistance.value.toString(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp, 10.dp, 10.dp),
            onValueChange = { clubsAddFormViewModel.setClubDistance(it) },
            label = { Text(text = "Enter Your Distance") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(onDone = { clubsAddFormViewModel.addClub(); keyboardController?.hide()})
        )

        Button(modifier =  Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp, 10.dp, 10.dp),
            onClick = { clubsAddFormViewModel.addClub(); keyboardController?.hide() }) {
            Text("Add Club")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClubsAddFormViewPreview() {
    val fakeRepository = ClubsDataRepositoryPreview()
    val test = ClubsAddFormViewModel(fakeRepository)
    ClubsAddFormView(closeBottomSheet = {}, clubsAddFormViewModel = test)
}