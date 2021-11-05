package com.example.integradorandroid.data.datasource

import android.util.Log
import com.example.integradorandroid.data.response.StatusResponse
import com.example.integradorandroid.data.api.ApiServices
import com.example.integradorandroid.data.model.TypeActivities
import com.example.integradorandroid.data.response.TypeStatus
import com.example.integradorandroid.data.retrofit.RetrofitServices
import java.lang.Exception

class ActivitiesRemoteDataSource {
    private val retrofit = RetrofitServices.instance.create(ApiServices::class.java)

    /**
     * type = hace referencia a la categoria
     * si llega nulo se hara consulta de actividades random
     */
    suspend fun getActivities(type : String?) : StatusResponse<TypeActivities> {
        return try {
            val response = type?.let {
                retrofit.getActivities(it)
            } ?: run {
                retrofit.getActivitiesRandom()
            }
            if(response.isSuccessful){
                StatusResponse(TypeStatus.SUCCESS,response.body())
            }else{
                StatusResponse(TypeStatus.ERROR,message = response.message())
            }
        }catch (e : Exception){
            Log.e("API SERVICES " , "Error en la petion al servicio")
            StatusResponse(TypeStatus.ERROR,message = e.message)
        }
    }
}