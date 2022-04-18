package com.example.inrecipe

class RecipesMaster {
    fun getAvailableDishes(
        allDishes: Set<Dish>,
        userIngredients: Set<IngredientEnum>
    ): MutableList<Dish> {
        return allDishes.filter {
            val intersection = it.ingredients.intersect(userIngredients)
            intersection.isNotEmpty() && intersection.size == it.ingredients.size
        }.toMutableList()
    }
}