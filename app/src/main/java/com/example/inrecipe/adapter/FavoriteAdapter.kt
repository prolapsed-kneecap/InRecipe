package com.example.inrecipe.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.inrecipe.data.IngredientEnum
import com.example.inrecipe.R
import com.example.inrecipe.data.Data
import com.example.inrecipe.data.Dish

class FavoriteAdapter(private val dataSet: MutableList<Dish>, val navController : NavController) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.recipeName)
        val imageView: ImageView = view.findViewById(R.id.recipeImageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.favorite_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("position", dataSet[position].index)
            navController.navigate(R.id.action_favoritesFragment2_to_recipeInspectFragment, bundle)
        }

        viewHolder.imageView.setImageResource(dataSet[position].image)
        viewHolder.textView.text = dataSet[position].name

//        var isChosen = false
//
//        Data.checked.forEach {
//            if (it == dataSet[position]) {
//                isChosen = true
//            }
//        }
//
//        if (isChosen.not()){
//            viewHolder.itemView.alpha = 0.5F
//        }
//        viewHolder.imageView.setImageResource(dataSet[position].image)
//
//        viewHolder.textView.text = dataSet[position].ingredientName
//
//        viewHolder.itemView.setOnClickListener {
//            if (isChosen) {
//                it.alpha = 0.5F
//                Data.checked.remove(dataSet[position])
//            } else {
//                it.alpha = 1F
//                Data.checked.add(dataSet[position])
//            }
//            isChosen = isChosen.not()
//        }
        /*viewHolder.checkBox.text = dataSet[position].name
            viewHolder.checkBox.setOnClickListener {
                var isChecked = viewHolder.checkBox.isChecked
                Log.d("BBB", isChecked.toString())
                if (isChecked) {
                    Data.checked.add(dataSet[position])
                } else {
                    Data.checked.remove(dataSet[position])
                }
                isChecked = viewHolder.checkBox.isChecked.not()
            }*/
    }

    override fun getItemCount() = dataSet.size

}