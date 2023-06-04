package com.elmenus.food.data.remote.menu

import com.google.gson.annotations.SerializedName

data class MainObject(
    @SerializedName("Announcements")
    val announcements: List<AnnouncementObject>,
    @SerializedName("Categories")
    val categories: List<CategoryObject>,
    @SerializedName("Ingredients")
    val ingredients: List<IngredientObject>,
    @SerializedName("Meals")
    val meals: List<MealObject>,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Url")
    val url: String
)