package com.g00fy2.punkapp.ui.beers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.g00fy2.punkapp.ui.main.MainUiState
import com.g00fy2.punkapp.ui.main.MainViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun BeersRoute(
  viewModel: MainViewModel,
  modifier: Modifier = Modifier
) {
  val mainUiState: MainUiState by viewModel.beerList.collectAsStateWithLifecycle()
  BeersScreen(
    mainUiState = mainUiState,
    modifier = modifier
  )
}

@Composable
fun BeersScreen(
  mainUiState: MainUiState,
  modifier: Modifier = Modifier
) {
  val navBarHeight = with(LocalDensity.current) {
    WindowInsets.navigationBars.getBottom(this).toDp()
  }
  LazyColumn(
    modifier = modifier.statusBarsPadding(),
    contentPadding = PaddingValues(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp + navBarHeight),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    when (mainUiState) {
      MainUiState.Loading -> {
        // do nothing
      }

      is MainUiState.MainState -> {
        items(items = mainUiState.beerList, key = { it.id }) { beer ->
          BeerCard(beer)
        }
      }
    }
  }
}