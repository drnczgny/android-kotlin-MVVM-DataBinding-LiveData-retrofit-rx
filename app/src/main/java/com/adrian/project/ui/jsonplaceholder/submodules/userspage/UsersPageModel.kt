package com.adrian.project.ui.jsonplaceholder.submodules.userspage

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class UsersPageModel constructor(val apiService: ApiService) {

    fun callApiService() = apiService.fakeApiCall()

}