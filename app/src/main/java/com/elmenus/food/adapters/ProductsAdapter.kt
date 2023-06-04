package com.elmenus.food.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elmenus.food.R
import com.elmenus.food.data.remote.menu.MealObject

class ProductsAdapter(private val data: List<MealObject>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
	 	val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.item_product_image_details, parent, false)

		return ViewHolder(view)
	}

 	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		val itemsViewModel = data[position]

	 	holder.productImage.load(itemsViewModel.strMealThumb)

	 	holder.productTitle.text = itemsViewModel.strMeal

		holder.productCategory.text = itemsViewModel.strCategory
		holder.productOrigin.text = itemsViewModel.strArea

	}
 	override fun getItemCount(): Int {
		return data.size
	}

 	class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
		val productImage: ImageView = itemView.findViewById(R.id.iv_product_image)
		val productTitle: TextView = itemView.findViewById(R.id.tv_product_title)
		val productCategory: TextView = itemView.findViewById(R.id.tv_product_category)
		val productOrigin: TextView = itemView.findViewById(R.id.tv_product_origin)
	}
}
