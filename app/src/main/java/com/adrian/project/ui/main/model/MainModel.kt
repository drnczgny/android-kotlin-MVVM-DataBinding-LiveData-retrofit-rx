package com.adrian.project.ui.main.model

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 03..
 */

class MainModel constructor(val apiService: ApiService) {

    fun callApiService() {
        apiService.fakeApiCall()
    }

}