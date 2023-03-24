package com.filipsyn.cardroid.viewmodels

import com.filipsyn.cardroid.architecture.BaseViewModel
import com.filipsyn.cardroid.database.ICarsRepository

class CarListViewModel(private var repository: ICarsRepository): BaseViewModel() {
}