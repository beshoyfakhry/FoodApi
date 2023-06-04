package com.elmenus.food.extensions

import android.app.Activity
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmenus.food.R
import com.elmenus.food.adapters.PopularIngredientsAdapter
import com.elmenus.food.adapters.ProductsAdapter
import com.elmenus.food.adapters.TopCategoriesAdapter
import com.elmenus.food.data.remote.menu.CategoryObject
import com.elmenus.food.data.remote.menu.IngredientObject
import com.elmenus.food.data.remote.menu.MealObject


fun Activity.createProductsView(numberOfColumns: Int, title: String, data: List<MealObject>): ConstraintLayout {

    val layout =
        prepareTheView(numberOfColumns, title)


    val adapter = ProductsAdapter(data)
    layout.findViewById<RecyclerView>(R.id.rv_data).adapter = adapter

    return layout

}

fun Activity.createCategoryListView(
    numberOfColumns: Int,
    title: String,
    data: List<CategoryObject>
): ConstraintLayout {

    val layout =
        prepareTheView(numberOfColumns, title)

    val adapter = TopCategoriesAdapter(data)
    layout.findViewById<RecyclerView>(R.id.rv_data).adapter = adapter

    return layout

}

fun Activity.createIngredientsView(
    numberOfColumns: Int,
    title: String,
    data: List<IngredientObject>
): ConstraintLayout {

    val layout =
        prepareTheView(numberOfColumns, title)

    val adapter = PopularIngredientsAdapter(data)

    layout.findViewById<RecyclerView>(R.id.rv_data).adapter = adapter


    return layout

}


private fun Activity.prepareTheView(numberOfColumns: Int, title: String): ConstraintLayout {
    val inflater = LayoutInflater.from(this)
    val layout =
        inflater.inflate(R.layout.text_recycle_layout, null, false) as ConstraintLayout


    val recyclerview = layout.findViewById<RecyclerView>(R.id.rv_data)
    val layoutManager =
        GridLayoutManager(this, numberOfColumns, GridLayoutManager.HORIZONTAL, false)
    recyclerview.layoutManager = layoutManager

    val headerTitle = layout.findViewById<TextView>(R.id.head_tittle)
    headerTitle.text = title

    return layout

}