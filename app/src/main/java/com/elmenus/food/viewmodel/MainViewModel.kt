package com.elmenus.food.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elmenus.food.data.Repository
import com.elmenus.food.data.remote.menu.DataObject
import com.elmenus.food.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<DataObject>> = MutableLiveData()
    val response: LiveData<NetworkResult<DataObject>> = _response

    fun fetchMenuResponse() = viewModelScope.launch {
        repository.getMenu().collect { values ->
            _response.value = values

        }
    }




}