package com.filipsyn.cardroid.navigation

sealed class Destination(val route: String) {
    object CarListScreen: Destination(route = "car_list")
    object CarDetailScreen: Destination(route = "car_detail")
    object AddEditCarScreen: Destination(route = "add_edit_car")
}