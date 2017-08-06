package com.adrian.project.ui.jsonplaceholder.submodules.albumspage

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class AlbumsPageModel constructor(val apiService: ApiService){

    fun callApiService() = apiService.fakeApiCall()

}