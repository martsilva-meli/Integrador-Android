package com.example.integradorandroid.data.api

import com.example.integradorandroid.data.model.TypeActivities
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/api/activity")
    suspend fun getActivities(
        @Query("type") type : String
    ) : Response<TypeActivities>

    @GET("api/activity/")
    suspend fun getActivitiesRandom() :  Response<TypeActivities>
}