package com.elmenus.food.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elmenus.food.R
import com.elmenus.food.data.remote.menu.IngredientObject

class PopularIngredientsAdapter(private val data: List<IngredientObject>) : RecyclerView.Adapter<PopularIngredientsAdapter.ViewHolder>() {

 	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
 		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.item_image_text, parent, false)

		return ViewHolder(view)
	}

 	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		val itemsViewModel = data[position]

 		holder.textView.text = itemsViewModel.strIngredient

	}

 	override fun getItemCount(): Int {
		return data.size
	}

 	class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
		val imageView: ImageView = itemView.findViewById(R.id.iv_image)
		val textView: TextView = itemView.findViewById(R.id.tv_text)
	}
}
