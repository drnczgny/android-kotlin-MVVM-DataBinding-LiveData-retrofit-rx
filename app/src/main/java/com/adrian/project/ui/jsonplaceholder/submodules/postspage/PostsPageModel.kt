package com.adrian.project.ui.jsonplaceholder.submodules.postspage

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class PostsPageModel constructor(val apiService: ApiService) {

    fun callApiService() = apiService.fakeApiCall()

}