package com.g00fy2.punkapp.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

inline fun <T> ViewModel.launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
  return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
    emitSource(block())
  }
}