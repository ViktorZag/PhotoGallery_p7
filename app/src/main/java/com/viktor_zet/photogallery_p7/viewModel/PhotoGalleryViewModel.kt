package com.viktor_zet.photogallery_p7.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.viktor_zet.photogallery_p7.api.FlickrFetchr
import com.viktor_zet.photogallery_p7.model.GalleryItem
import com.viktor_zet.photogallery_p7.utils.QueryPreferences

class PhotoGalleryViewModel(private val app: Application) : AndroidViewModel(app) {

    private val flickrFetchr = FlickrFetchr()
    private val mutableSearchTerm = MutableLiveData<String>()

    val searchTerm: String
        get() = mutableSearchTerm.value ?: ""

    val galleryItemLiveData: LiveData<List<GalleryItem>>
    init {
        mutableSearchTerm.value = QueryPreferences.getStoredQuery(app)
        galleryItemLiveData = Transformations.switchMap(mutableSearchTerm) { searchTerm ->
            if (searchTerm.isBlank()){
                flickrFetchr.fetchPhotos()
            }else flickrFetchr.searchPhotos(searchTerm)
        }
    }
    fun fetchPhotos(query: String = "") {
        QueryPreferences.setStoredQuery(app, query)
        mutableSearchTerm.value = query
    }
}