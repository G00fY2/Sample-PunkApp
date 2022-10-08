package com.g00fy2.punkapp.ui.main

import com.g00fy2.punkapp.model.entities.domain.Beer

sealed interface MainUiState {

  object Loading : MainUiState

  data class MainState(val beerList: List<Beer>) : MainUiState
}