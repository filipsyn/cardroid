package com.filipsyn.cardroid.ui.screens

sealed class AddEditCarUIState {
    object Default: AddEditCarUIState()
    object CarSaved: AddEditCarUIState()
}