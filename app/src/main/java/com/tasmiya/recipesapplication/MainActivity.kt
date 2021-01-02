package com.tasmiya.recipesapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasmiya.recipesapplication.util.NetworkResult
import com.tasmiya.recipesapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    private val mAdapter by lazy { RecipesAdapter() }
    private lateinit var mView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        requestApiData()
    }



// recyclerview with recipes
    private fun requestApiData() {
        mainViewModel.getRecipes(mainViewModel.applyQueries())
        mainViewModel.recipesResponse.observe(this, { response ->
            when(response){
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(
                            this,
                            response.message.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading ->{
                    showShimmerEffect()
                }
            }
        })
    }

    private fun setupRecyclerView() {
       rcvRecipe.adapter = mAdapter
        rcvRecipe.layoutManager = LinearLayoutManager(this)
        showShimmerEffect()
    }

    private fun showShimmerEffect() {
        rcvRecipe.showShimmer()
    }

    private fun hideShimmerEffect() {
        rcvRecipe.hideShimmer()
    }

}



