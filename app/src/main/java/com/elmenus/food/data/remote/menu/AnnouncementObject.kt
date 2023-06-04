package com.elmenus.food.data.remote.menu

import com.google.gson.annotations.SerializedName

data class AnnouncementObject(
    @SerializedName("Category")
    val category: CategoryObject,
    @SerializedName("Meal")
    val meal: MealObject,

    val id: Int,
    val strThumb: String
)
{




}