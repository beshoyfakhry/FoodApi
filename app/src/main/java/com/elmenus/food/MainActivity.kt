package com.elmenus.food


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.elmenus.food.data.remote.menu.*
import com.elmenus.food.databinding.ActivityMainBinding
import com.elmenus.food.extensions.createCategoryListView
import com.elmenus.food.extensions.createIngredientsView
import com.elmenus.food.extensions.createProductsView

import com.elmenus.food.utils.NetworkResult
import com.elmenus.food.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData()

    }

    private fun fetchData() {
        fetchResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        drawViews(it.data)
                    }
                    _binding.pbMenu.visibility = View.GONE
                }

                is NetworkResult.Error -> {
                    _binding.pbMenu.visibility = View.GONE
                    Toast.makeText(
                        this,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    _binding.pbMenu.visibility = View.VISIBLE
                }
            }
        }
    }


    private fun drawViews(categories: DynamicCollectionArrayObject) {

        categories.DynamicCollectionViewModel.forEach {
            when (it.type) {
                "Category" -> updateTheCategoriesList(it.title, it.categories)
                "Product" -> updateTheProductsList(it.title, it.meals)
                "Ingredients" -> updateIngredientsList(it.title, it.ingredients)
                "Announcement" -> updateAnnouncementsList(it.title, it.announcements)
                "MOTDY" -> updateMealOfTheDayView(it.url)
            }
        }

    }

    private fun updateTheCategoriesList(title: String, data: List<CategoryObject>) {

        _binding.mainLayout.addView(createCategoryListView(1, title, data))
    }

    private fun updateTheProductsList(title: String, data: List<MealObject>) {

        _binding.mainLayout.addView(createProductsView(2, title, data))


    }

    private fun updateIngredientsList(title: String, data: List<IngredientObject>) {

        _binding.mainLayout.addView(createIngredientsView(1, title, data))

    }

    private fun updateAnnouncementsList(title: String, announcements: List<AnnouncementObject>) {
        val imagesList = ArrayList<SlideModel>()
        announcements.forEach {
            imagesList.add(SlideModel(it.strThumb))
        }


        val inflater = LayoutInflater.from(this)
        val layout =
            inflater.inflate(R.layout.carousel_layout, null, false) as LinearLayout


        val carousel = layout.findViewById<ImageSlider>(R.id.image_slider)
        carousel.setImageList(imagesList)

        val headerTitle = layout.findViewById<TextView>(R.id.head_tittle)
        headerTitle.text = title

        _binding.mainLayout.addView(layout)


    }

    private fun updateMealOfTheDayView(url: String) {

        val inflater = LayoutInflater.from(this)
        val layout =
            inflater.inflate(R.layout.meal_of_today_layout, null, false) as ConstraintLayout
        layout.findViewById<ImageView>(R.id.iv_meal_of_the_day).load(url)
        _binding.mainLayout.addView(layout, 0)

    }


    private fun fetchResponse() {
        mainViewModel.fetchMenuResponse()
        _binding.pbMenu.visibility = View.VISIBLE
    }


}
