package com.filipsyn.cardroid.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.filipsyn.cardroid.architecture.BaseViewModel
import com.filipsyn.cardroid.database.ICarsRepository
import com.filipsyn.cardroid.ui.screens.CarListActions
import com.filipsyn.cardroid.ui.screens.CarListUIState
import kotlinx.coroutines.launch

class CarListViewModel(private val repository: ICarsRepository) : BaseViewModel(), CarListActions{
    val carListUIState: MutableState<CarListUIState> = mutableStateOf(CarListUIState.Default)

    fun loadCars(){
        launch {
            repository.getAll().collect {
                carListUIState.value = CarListUIState.Success(it)
            }
        }
    }



}