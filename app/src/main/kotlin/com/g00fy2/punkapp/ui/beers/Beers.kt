package com.g00fy2.punkapp.ui.beers

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.ui.main.MainViewModel

@Composable
fun Beers(viewModel: MainViewModel) {

  val beers: List<Beer> by viewModel.beerList.observeAsState(listOf())

  Text(beers.joinToString { it.name })
}