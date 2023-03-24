package com.filipsyn.cardroid.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.filipsyn.cardroid.navigation.INavigationRouter
import com.filipsyn.cardroid.ui.elements.BackArrowScreen

@Composable
fun CarDetailScreen(navigation: INavigationRouter, id: Long?) {
    BackArrowScreen(appBarTitle = "Detail of car" , onBackClick = { /*TODO*/ }) {
        CarDetailScreenContent()
    }
}

@Composable
fun CarDetailScreenContent(){
    Text("Detail")
}