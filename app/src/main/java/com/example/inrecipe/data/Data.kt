package com.example.inrecipe.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object Data {
    val dishes = mutableSetOf<Dish>(
        Dish(
            1,
            "Салат из яблок и мандаринов",
            setOf(
                IngredientEnum.APPLE,
                IngredientEnum.TANGERINE
            )
        ),
        Dish(
            2,
            "Томатное нечто",
            setOf(
                IngredientEnum.TOMATO,
            )
        ),
        Dish(
            3,
            "Яичница",
            setOf(
                IngredientEnum.EGGS
            )
        ),
        Dish(
            4,
            "Яблочный пирог",
            setOf(
                IngredientEnum.APPLE,
                IngredientEnum.FLOUR,
                IngredientEnum.MILK,
                IngredientEnum.EGGS
            )
        ),
        Dish(
            5,
            "ааа",
            setOf(
                IngredientEnum.APPLE,
                IngredientEnum.FLOUR,
                IngredientEnum.MILK,
                IngredientEnum.EGGS,
                IngredientEnum.TANGERINE,
                IngredientEnum.TOMATO
            )
        )
    )
    val checked = mutableSetOf<IngredientEnum>(
    )

    var availableDishes = listOf<Dish>()

    val database = Firebase.firestore

    var favorites = mutableListOf<Int>(
        1,
        3,
        4
    )
}