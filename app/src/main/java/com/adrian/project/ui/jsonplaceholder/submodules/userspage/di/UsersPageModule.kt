package com.adrian.project.ui.jsonplaceholder.submodules.userspage.di

import com.adrian.project.data.ApiService
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.userspage.UsersPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.userspage.UsersPageRouter
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class UsersPageModule {

    @FragmentScope
    @Provides
    fun providesUsersPageRouter(usersPageRouter: UsersPageRouter): UsersPageRouter = usersPageRouter

    @FragmentScope
    @Provides
    fun providesUsersPageModel(apiService: ApiService) = UsersPageModel(apiService)

}