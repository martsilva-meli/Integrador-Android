package com.example.integradorandroid.presentations.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.integradorandroid.data.response.StatusResponse
import com.example.integradorandroid.data.model.TypeActivities
import com.example.integradorandroid.data.response.TypeStatus
import com.example.integradorandroid.domain.repository.RepositoryActivities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryViewModel constructor(
    private val repository: RepositoryActivities
) : ViewModel() {

    /**
     * _activities = esta variable se encarga de almacenar los datos
     * obtenidos del repositorio, solo se puede usar en el viewmodel
     *
     * activities = es un get de la variable _activities para usarla
     * fuera del viewmodel
     */
    private val _activities = MutableLiveData<StatusResponse<TypeActivities>>()
    val activities: LiveData<StatusResponse<TypeActivities>>
        get() = _activities

    fun getActivities(type: String? = null) {
        _activities.value = StatusResponse(TypeStatus.LOADING)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getActivities(type)
            }.also { _activities.value = it }
        }
    }
}