package com.filipsyn.cardroid.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.filipsyn.cardroid.navigation.INavigationRouter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarListScreen(navigation: INavigationRouter) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Cars list")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {navigation.navigateToAddEditCarScreen(-1L)}) {
                Text(text = "+")
            }
        }
    ) {
        CarListScreenContent(paddingValues = it)
    }
}

@Composable
fun CarListScreenContent (paddingValues: PaddingValues){
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
       item {
          Text("Empty car list")
       }
    }
}