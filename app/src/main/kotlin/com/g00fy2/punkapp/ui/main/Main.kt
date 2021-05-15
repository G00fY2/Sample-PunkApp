package com.g00fy2.punkapp.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.g00fy2.punkapp.ui.beers.Beers
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PunkMain() {
  val navController = rememberNavController()

  ProvideWindowInsets {
    NavHost(navController, "home") {
      composable("home") { backStackEntry ->
        val viewModel = hiltNavGraphViewModel<MainViewModel>(backStackEntry)
        Beers(viewModel)
      }
    }
  }
}
