package br.com.entrypoint.mycinemalistyt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.entrypoint.mycinemalistyt.R
import br.com.entrypoint.mycinemalistyt.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.call.setOnClickListener {
            callPopularMovies()
        }
        mainViewModel.popularMovie.observe(this,{ popularMovies ->
            popularMovies.forEach {
                Log.i("PopularMovie", it.title)
            }
        })

    }

    private fun callPopularMovies(){
        GlobalScope.launch {
            mainViewModel.getPopularMovies()
        }
    }
}