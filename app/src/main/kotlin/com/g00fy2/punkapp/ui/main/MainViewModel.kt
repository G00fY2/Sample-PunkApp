package com.g00fy2.punkapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(beerDatastore: BeerDatastore) : ViewModel() {

  val beerList: StateFlow<MainUiState> = beerDatastore.getAllBeers()
    .map { MainUiState.MainState(beerList = it) }
    .stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(5_000),
      initialValue = MainUiState.Loading
    )
}