package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.model.CommentsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service.CommentService
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service.CommentServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service.DefaultCommentServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.view.CommentsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.view.CommentsPageRouter
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.CommentsPageViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

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
    fun providesCommentService(@Named("jsonplaceholderapi") retrofit: Retrofit): CommentService = retrofit.create(CommentService::class.java)

    @FragmentScope
    @Provides
    @Named("DefaultCommentServiceInteractor")
    fun providesCommentServiceInteractor(commentService: CommentService): CommentServiceInteractor = DefaultCommentServiceInteractor(commentService)

    @FragmentScope
    @Provides
    fun providesCommentsPageModel(@Named("DefaultCommentServiceInteractor") interactor: CommentServiceInteractor) = CommentsPageModel(interactor)

    @FragmentScope
    @Provides
    fun providesCommentsPageViewModel(router: CommentsPageRouter, model: CommentsPageModel) = CommentsPageViewModel(router, model)
}