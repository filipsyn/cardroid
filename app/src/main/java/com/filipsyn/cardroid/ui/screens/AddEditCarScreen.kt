package com.filipsyn.cardroid.ui.screens

import androidx.compose.runtime.Composable
import com.filipsyn.cardroid.navigation.INavigationRouter
import com.filipsyn.cardroid.ui.elements.BackArrowScreen

@Composable
fun AddEditCarScreen(navigation: INavigationRouter, id: Long?) {
    BackArrowScreen(appBarTitle = "Edit car", onBackClick = { /*TODO*/ }) {
       AddEditCarScreenContent()
    }
}

@Composable
fun AddEditCarScreenContent(){

}