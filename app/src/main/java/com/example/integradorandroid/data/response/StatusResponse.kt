package com.example.integradorandroid.data.response

data class StatusResponse<out T>(
    val status : TypeStatus,
    val response : T? = null,
    val message : String? = null
)
