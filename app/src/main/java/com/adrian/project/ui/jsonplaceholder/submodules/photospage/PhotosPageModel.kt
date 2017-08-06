package com.adrian.project.ui.jsonplaceholder.submodules.photospage

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class PhotosPageModel constructor(val apiService: ApiService){

    fun callApiService() = apiService.fakeApiCall()

}