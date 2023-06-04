package com.elmenus.food.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val menuService: MenuService) {

    suspend fun getMenu() =
        menuService.getMenu()

}