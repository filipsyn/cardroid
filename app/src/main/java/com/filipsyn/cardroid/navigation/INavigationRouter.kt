package com.filipsyn.cardroid.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddEditCarScreen(id: Long?)
    fun navigateToCarDetailScreen(id: Long?)
    fun getNavController(): NavController
}