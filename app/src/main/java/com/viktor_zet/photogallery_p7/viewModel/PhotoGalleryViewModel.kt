package com.viktor_zet.photogallery_p7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.viktor_zet.photogallery_p7.api.FlickrFetchr
import com.viktor_zet.photogallery_p7.model.GalleryItem

class PhotoGalleryViewModel:ViewModel() {

    val galleryItemLiveData: LiveData<List<GalleryItem>>
    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }
}