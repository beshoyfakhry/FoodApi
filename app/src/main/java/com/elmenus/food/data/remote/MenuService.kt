package com.elmenus.food.data.remote

import com.elmenus.food.data.remote.menu.DataObject
import com.elmenus.food.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {

    @GET(Constants.HOME_URL)
    suspend fun getMenu(): Response<DataObject>
}
