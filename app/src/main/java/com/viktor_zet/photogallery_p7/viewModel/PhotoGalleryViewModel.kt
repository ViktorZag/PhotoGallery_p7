package com.viktor_zet.photogallery_p7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.viktor_zet.photogallery_p7.api.FlickrFetchr
import com.viktor_zet.photogallery_p7.model.GalleryItem

class PhotoGalleryViewModel:ViewModel() {

    private val flickrFetchr = FlickrFetchr()
    private val mutableSearchTerm = MutableLiveData<String>()

    val galleryItemLiveData: LiveData<List<GalleryItem>>
    init {
        mutableSearchTerm.value = "planets"
        galleryItemLiveData = Transformations.switchMap(mutableSearchTerm) { searchTerm ->
            flickrFetchr.searchPhotos(searchTerm)
        }
    }
    fun fetchPhotos(query: String = "") {
        mutableSearchTerm.value = query
    }
}