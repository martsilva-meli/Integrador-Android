package com.example.integradorandroid.presentations.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.integradorandroid.data.datasource.ActivitiesRemoteDataSource
import com.example.integradorandroid.domain.repository.RepositoryActivities

class CategoryViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = RepositoryActivities(
           ActivitiesRemoteDataSource()
        )
        return CategoryViewModel(repository) as T
    }
}