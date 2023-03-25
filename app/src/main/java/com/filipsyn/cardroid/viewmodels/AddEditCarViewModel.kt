package com.filipsyn.cardroid.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.filipsyn.cardroid.architecture.BaseViewModel
import com.filipsyn.cardroid.database.ICarsRepository
import com.filipsyn.cardroid.model.Car
import com.filipsyn.cardroid.ui.screens.AddEditCarActions
import com.filipsyn.cardroid.ui.screens.AddEditCarUIState
import kotlinx.coroutines.launch

class AddEditCarViewModel(private val repository: ICarsRepository) : BaseViewModel(),
    AddEditCarActions {

    val addEditCarUIState: MutableState<AddEditCarUIState> =
        mutableStateOf(AddEditCarUIState.Default)

    override fun saveCar(registrationPlate: String) {
        launch {
            val id = repository.insert(Car(registrationPlate = registrationPlate ))

            if (id > 0){
                addEditCarUIState.value = AddEditCarUIState.CarSaved
            } else {
                //Error
            }
        }
    }
}