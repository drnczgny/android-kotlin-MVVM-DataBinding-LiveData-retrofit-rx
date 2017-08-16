package com.adrian.project.ui.jsonplaceholder.submodules.postspage.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.service.DefaultPostServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.service.PostService
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.service.PostServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.view.PostsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.model.PostsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.view.PostsPageRouter
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.PostsPageViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class PostsPageModule {

    @FragmentScope
    @Provides
    fun providesPostsPageRouter(postsPageFragment: PostsPageFragment): PostsPageRouter = postsPageFragment

    @FragmentScope
    @Provides
    fun providesPostService(@Named("jsonplaceholderapi") retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)

    @FragmentScope
    @Provides
    @Named("DefaultPostServiceInteractor")
    fun providesPostServiceInteractor(postService: PostService): PostServiceInteractor = DefaultPostServiceInteractor(postService)

    @FragmentScope
    @Provides
    fun providesPostsPageModel(@Named("DefaultPostServiceInteractor") interactor: PostServiceInteractor) = PostsPageModel(interactor)

    @FragmentScope
    @Provides
    fun providesPostsPageViewModel(model: PostsPageModel, router: PostsPageRouter)
            = PostsPageViewModel(model, router);

}