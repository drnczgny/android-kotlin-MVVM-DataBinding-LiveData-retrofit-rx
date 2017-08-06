package com.adrian.project.ui.jsonplaceholder.submodules.todospage

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class TodosPageModel constructor(val apiService: ApiService) {

    fun callApiService() = apiService.fakeApiCall()

}