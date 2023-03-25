package com.filipsyn.cardroid.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.filipsyn.cardroid.model.Car
import com.filipsyn.cardroid.navigation.INavigationRouter
import com.filipsyn.cardroid.viewmodels.CarListViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarListScreen(
    navigation: INavigationRouter,
    viewModel: CarListViewModel = getViewModel()
) {
    var cars = remember { mutableStateListOf<Car>() }

    viewModel.carListUIState.value.let {
        when (it) {
            CarListUIState.Default -> {
                viewModel.loadCars()
            }

            is CarListUIState.Success -> {
                cars.clear()
                cars.addAll(it.cars)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Cars list")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navigation.navigateToAddEditCarScreen(-1L) }) {
                Text(text = "+")
            }
        }
    ) {
        CarListScreenContent(
            paddingValues = it,
            cars = cars,
            navigation = navigation,
            actions = viewModel
        )
    }
}

@Composable
fun CarListScreenContent(
    paddingValues: PaddingValues,
    cars: List<Car>,
    navigation: INavigationRouter,
    actions: CarListActions,
) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        cars.forEach {
            item(key = it.id) {
                CarRow(
                    car = it,
                    actions = actions,
                    onRowClick = {
                        navigation.navigateToCarDetailScreen(it.id)
                    }
                )
            }
        }
    }
}

@Composable
fun CarRow(
    car: Car,
    onRowClick: () -> Unit,
    actions: CarListActions
) {
    Row(modifier = Modifier.clickable(onClick = onRowClick)) {
        Column() {
            Text(text = car.registrationPlate)
        }
    }

}