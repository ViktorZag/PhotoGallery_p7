package com.viktor_zet.photogallery_p7.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface FlickrApi {

    @GET("services/rest/?method=flickr.interestingness.getList" +
                "&api_key=a271fba6aab628f0c586b214ba3e625a" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>

    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>
}