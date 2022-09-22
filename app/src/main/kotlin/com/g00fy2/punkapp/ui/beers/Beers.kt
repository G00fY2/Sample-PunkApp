package com.g00fy2.punkapp.ui.beers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.ui.main.MainViewModel

@Composable
fun Beers(viewModel: MainViewModel, modifier: Modifier = Modifier) {
  val beers: List<Beer> by viewModel.beerList.collectAsState()

  LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(8.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    items(items = beers, key = { it.id }) { beer ->
      BeerCard(beer)
    }
  }
}