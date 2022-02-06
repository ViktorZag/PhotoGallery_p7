package com.viktor_zet.photogallery_p7.api

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi {

    @GET("/")
    fun fetchContents(): Call<String>

}