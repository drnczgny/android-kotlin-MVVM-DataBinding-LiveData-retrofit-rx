package com.adrian.project.ui.jsonplaceholder.submodules.todospage.di

import com.adrian.project.data.ApiService
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.todospage.TodosPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.todospage.TodosPageRouter
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class TodosPageModule {

    @FragmentScope
    @Provides
    fun providesTodosPageRouter(todosPageRouter: TodosPageRouter): TodosPageRouter = todosPageRouter

    @FragmentScope
    @Provides
    fun providesTodosPageModel(apiService: ApiService) = TodosPageModel(apiService)

}