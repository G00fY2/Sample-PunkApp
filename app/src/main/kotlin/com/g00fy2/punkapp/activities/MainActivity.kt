package com.g00fy2.punkapp.activities

import androidx.lifecycle.lifecycleScope
import com.g00fy2.punkapp.base.BaseActivity
import com.g00fy2.punkapp.databinding.ActivityMainBinding
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {

  @Inject
  lateinit var beerDatastore: BeerDatastore

  override val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

  override fun initView() {
  }

  override fun onResume() {
    super.onResume()
    lifecycleScope.launch {
      try {
        withContext(Dispatchers.IO) { beerDatastore.getAllBeers() }.let {
          binding.testTextview.text = it.joinToString { beer -> beer.name }
        }
      } catch (e: Exception) {
        Timber.e(e)
        binding.testTextview.text = "Error loading data"
      }
    }
  }
}