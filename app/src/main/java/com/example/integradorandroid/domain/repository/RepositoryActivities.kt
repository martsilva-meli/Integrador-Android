package com.example.integradorandroid.domain.repository

import com.example.integradorandroid.data.response.StatusResponse
import com.example.integradorandroid.data.datasource.ActivitiesRemoteDataSource
import com.example.integradorandroid.data.model.TypeActivities

class RepositoryActivities constructor(
    private val dataSource: ActivitiesRemoteDataSource
){

    // esta funcion me retorna un statusResponse con la activity obtenida del api
    suspend fun getActivities(type : String?) : StatusResponse<TypeActivities> {
       return dataSource.getActivities(type)
    }
}