package com.example.inrecipe.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.inrecipe.data.Dish
import com.example.inrecipe.R
import com.example.inrecipe.data.Data
import com.example.inrecipe.ui.fragment.DishFragment


class DishPagerAdapter internal constructor(
    fm: FragmentManager?,
    context: Context,
    dishes: List<Dish>
) :
    FragmentStatePagerAdapter(fm!!) {
    private lateinit var mDishNames: MutableList<String>
    private lateinit var mDishDescriptions: MutableList<String>

    override fun getItem(position: Int): Fragment {
        val arguments = Bundle()
        arguments.putString(DishFragment.CAT_NAMES, mDishNames[position])

        arguments.putString(
            DishFragment.CAT_DESCRIPTIONS,
            mDishDescriptions[position]
        )
        arguments.putInt(DishFragment.TOP_IMAGE, Data.mTopImageResourceIds[position])
        arguments.putString("recipe", Data.recipes[position])
        val catsFragment = DishFragment()
        catsFragment.arguments = arguments
        return catsFragment
    }

    override fun getCount(): Int {
        return mDishNames.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mDishNames[position]
    }

    init {
        val resources = context.resources
        mDishNames = mutableListOf()
        mDishDescriptions = mutableListOf()
        dishes.forEach {
            mDishNames.add(it.name)
            var ingredientString = "Ингредиенты: "
            it.ingredients.forEach {
                ingredientString += "${it.ingredientName} "
            }
            mDishDescriptions.add(ingredientString)
        }
    }
}