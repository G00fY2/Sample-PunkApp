package com.g00fy2.punkapp.ui.beers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.ui.main.MainViewModel

@Composable
fun Beers(viewModel: MainViewModel, modifier: Modifier = Modifier) {
  val beers: List<Beer> by viewModel.beerList.collectAsState()

  val navBarHeight = with(LocalDensity.current) {
    WindowInsets.navigationBars.getBottom(this).toDp()
  }

  LazyColumn(
    modifier = modifier.statusBarsPadding(),
    contentPadding = PaddingValues(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp + navBarHeight),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    items(items = beers, key = { it.id }) { beer ->
      BeerCard(beer)
    }
  }
}