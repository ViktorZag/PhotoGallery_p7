package com.viktor_zet.photogallery_p7.api

import com.google.gson.annotations.SerializedName
import com.viktor_zet.photogallery_p7.model.GalleryItem

class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}