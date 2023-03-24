package com.filipsyn.cardroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.filipsyn.cardroid.ui.screens.AddEditCarScreen
import com.filipsyn.cardroid.ui.screens.CarDetailScreen
import com.filipsyn.cardroid.ui.screens.CarListScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    navigation: INavigationRouter = remember { NavigationRouterImpl(navController) },
    startDestination: String
) {

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Destination.CarListScreen.route) {
            CarListScreen(navigation)
        }


        composable(
            Destination.CarDetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id")
            CarDetailScreen(
                navigation = navigation,
                id = if (id != -1L) id else null
            )
        }

        composable(
            Destination.AddEditCarScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id")
            AddEditCarScreen(
                navigation = navigation,
                id = if (id != -1L) id else null
            )
        }
    }
}