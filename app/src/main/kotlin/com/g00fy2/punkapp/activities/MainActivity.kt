package com.g00fy2.punkapp.activities

import androidx.lifecycle.lifecycleScope
import com.g00fy2.punkapp.base.BaseActivity
import com.g00fy2.punkapp.databinding.ActivityMainBinding
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

  @Inject
  lateinit var beerDatastore: BeerDatastore

  override val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

  override fun initView() {
    // TODO
  }

  override fun onResume() {
    super.onResume()
    lifecycleScope.launch {
      try {
        withContext(Dispatchers.IO) { beerDatastore.getAllBeers() }.let {
          binding.testTextview.text = it.joinToString { beer -> beer.name }
        }
      } catch (e: IOException) {
        Timber.e(e)
        binding.testTextview.text = "Error loading data"
      }
    }
  }
}