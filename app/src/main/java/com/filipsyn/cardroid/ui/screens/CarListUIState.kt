package com.filipsyn.cardroid.ui.screens

import com.filipsyn.cardroid.model.Car

sealed class CarListUIState {
    object Default: CarListUIState()
    class Success(val cars: List<Car>): CarListUIState()
}