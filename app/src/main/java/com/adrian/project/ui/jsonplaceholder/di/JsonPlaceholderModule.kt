package com.adrian.project.ui.jsonplaceholder.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.project.data.ApiService
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.JsonPlaceholderModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.JsonPlaceholderRouter
import com.adrian.project.ui.jsonplaceholder.viewmodel.JsonPlaceholderViewModel
import com.adrian.project.ui.jsonplaceholder.viewpager.JsonPlaceholderViewPagerAdapter
import com.adrian.project.ui.jsonplaceholder.viewpager.JsonPlaceholderViewPagerDataModel
import com.adrian.project.ui.main.JsonPlaceholderActivity
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class JsonPlaceholderModule {

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderRouter(jsonPlaceholderActivity: JsonPlaceholderActivity): JsonPlaceholderRouter = jsonPlaceholderActivity

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderModel(apiService: ApiService) = JsonPlaceholderModel(apiService)

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderViewModel(jsonPlaceholderModel: JsonPlaceholderModel, jsonPlaceholderRouter: JsonPlaceholderRouter)
            = JsonPlaceholderViewModel(jsonPlaceholderModel, jsonPlaceholderRouter)

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderViewPagerDataModel() = JsonPlaceholderViewPagerDataModel()

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderViewPagerAdapter(jsonPlaceholderActivity: JsonPlaceholderActivity, datamodel: JsonPlaceholderViewPagerDataModel)
             = JsonPlaceholderViewPagerAdapter(jsonPlaceholderActivity.supportFragmentManager, datamodel)
}