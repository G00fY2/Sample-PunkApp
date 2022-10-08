package com.g00fy2.punkapp.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.g00fy2.punkapp.ui.beers.BeersRoute

@Composable
fun PunkMain() {
  val navController = rememberNavController()

  @Suppress("ViewModelInjection")
  NavHost(navController, "home") {
    composable("home") { backStackEntry ->
      val viewModel = hiltViewModel<MainViewModel>(backStackEntry)
      BeersRoute(viewModel)
    }
  }
}