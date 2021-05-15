package com.g00fy2.punkapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.g00fy2.punkapp.base.LiveCoroutinesViewModel
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import com.g00fy2.punkapp.model.entities.domain.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val beerDatastore: BeerDatastore) : LiveCoroutinesViewModel() {

  private var _beerList: MutableLiveData<Boolean> = MutableLiveData(true)

  val beerList: LiveData<List<Beer>> = _beerList.switchMap {
    launchOnViewModelScope {
      beerDatastore.getAllBeers().asLiveData()
    }
  }
}