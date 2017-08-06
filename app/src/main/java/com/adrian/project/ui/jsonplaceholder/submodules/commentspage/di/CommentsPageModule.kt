package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.di

import com.adrian.project.data.ApiService
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.CommentsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.CommentsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.CommentsPageRouter
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class CommentsPageModule {

    @FragmentScope
    @Provides
    fun providesCommentsPageRouter(commentsPageFragment: CommentsPageFragment): CommentsPageRouter = commentsPageFragment

    @FragmentScope
    @Provides
    fun providesCommentsPageModel(apiService: ApiService) = CommentsPageModel(apiService)
}