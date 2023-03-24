package com.filipsyn.cardroid.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToAddEditCarScreen(id: Long?) {
        navController.navigate(Destination.AddEditCarScreen.route + "/" + id)
    }

    override fun navigateToCarDetailScreen(id: Long?) {
        navController.navigate(Destination.CarDetailScreen.route + "/" + id)
    }

    override fun getNavController(): NavController = navController

}