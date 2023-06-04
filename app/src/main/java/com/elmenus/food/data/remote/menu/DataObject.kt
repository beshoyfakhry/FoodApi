package com.elmenus.food.data.remote.menu

import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("Data")
    val data: DynamicCollectionArrayObject
)