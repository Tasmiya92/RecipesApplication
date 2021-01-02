package com.tasmiya.recipesapplication


import com.tasmiya.recipesapplication.models.FoodRecipe
import com.tasmiya.recipesapplication.network.FoodRecipeApi
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipeApi: FoodRecipeApi
) {
    // Gets Recipes
    suspend fun getRecipes(queries : Map<String,String>): Response<FoodRecipe>{
        return foodRecipeApi.getRecipes(queries)

}
}