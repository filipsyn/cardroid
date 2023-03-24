package com.filipsyn.cardroid.di

import com.filipsyn.cardroid.viewmodels.CarListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CarListViewModel(get()) }
}