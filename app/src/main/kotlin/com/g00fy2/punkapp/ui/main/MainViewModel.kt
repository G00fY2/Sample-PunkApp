package com.g00fy2.punkapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import com.g00fy2.punkapp.model.entities.domain.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val beerDatastore: BeerDatastore) : ViewModel() {

  private val _beerList: MutableStateFlow<List<Beer>> = MutableStateFlow(emptyList())
  val beerList: StateFlow<List<Beer>> = _beerList

  init {
    viewModelScope.launch {
      beerDatastore.getAllBeers().collect { _beerList.value = it }
    }
  }
}