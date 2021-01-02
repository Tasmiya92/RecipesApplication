package com.tasmiya.recipesapplication.util

class Constants {

    companion object {

        //Spoonacular api fetches different types of recipes based on the queries
        const val BASE_URL = "https://api.spoonacular.com"
        const val API_KEY="9a8b028e74a1466387572adc95ebbf49"

        // API Query Keys
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

    }

}