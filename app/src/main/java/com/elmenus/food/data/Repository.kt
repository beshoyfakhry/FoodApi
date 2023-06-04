package com.elmenus.food.data

import com.elmenus.food.data.remote.RemoteDataSource
import com.elmenus.food.data.remote.menu.DataObject
import com.elmenus.food.model.BaseApiResponse
import com.elmenus.food.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getMenu(): Flow<NetworkResult<DataObject>> {
        return flow<NetworkResult<DataObject>> {
            emit(safeApiCall { remoteDataSource.getMenu() })
        }.flowOn(Dispatchers.IO)
    }

}
