package com.adrian.project.ui.jsonplaceholder.submodules.postspage.di

import com.adrian.project.data.ApiService
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.PostsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.PostsPageRouter
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class PostsPageModule {

    @FragmentScope
    @Provides
    fun providesPostsPageRouter(postsPageRouter: PostsPageRouter): PostsPageRouter = postsPageRouter

    @FragmentScope
    @Provides
    fun providesPostsPageModel(apiService: ApiService) = PostsPageModel(apiService)

}