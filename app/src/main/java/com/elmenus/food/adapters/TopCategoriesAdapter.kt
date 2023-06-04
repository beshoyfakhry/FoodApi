package com.elmenus.food.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elmenus.food.R
import com.elmenus.food.data.remote.menu.CategoryObject

class TopCategoriesAdapter(private val data: List<CategoryObject>) :
    RecyclerView.Adapter<TopCategoriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_text, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = data[position]


        holder.imageView.load(itemsViewModel.strCategoryThumb)
        holder.textView.text = itemsViewModel.strCategory

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_image)
        val textView: TextView = itemView.findViewById(R.id.tv_text)
    }
}
