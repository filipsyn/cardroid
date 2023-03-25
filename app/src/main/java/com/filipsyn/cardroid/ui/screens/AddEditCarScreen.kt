package com.filipsyn.cardroid.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.filipsyn.cardroid.navigation.INavigationRouter
import com.filipsyn.cardroid.ui.elements.BackArrowScreen
import com.filipsyn.cardroid.viewmodels.AddEditCarViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AddEditCarScreen(
    navigation: INavigationRouter, id: Long?,
    viewModel: AddEditCarViewModel = getViewModel()
) {
    BackArrowScreen(
        appBarTitle = "Add or edit car",
        onBackClick = { navigation.navigateBack() })
    {

        viewModel.addEditCarUIState.value.let {
            when (it) {
                AddEditCarUIState.Default -> {}

                AddEditCarUIState.CarSaved -> {
                    LaunchedEffect(it) {
                        navigation.navigateBack()
                    }
                }
            }
        }

        AddEditCarScreenContent(actions = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditCarScreenContent(actions: AddEditCarActions) {
    var registrationPlate = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = registrationPlate.value,
        label = {
            Text(text = "Registration plate of car")
        },
        onValueChange = { registrationPlate.value = it })

    OutlinedButton(onClick = {
        actions.saveCar(registrationPlate.value)
    }) {
        Text(text = "Submit")
    }
}