package com.adrian.project.ui.jsonplaceholder.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.view.AlbumsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.di.AlbumsPageModule
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.CommentsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.di.CommentsPageModule
import com.adrian.project.ui.jsonplaceholder.submodules.photospage.PhotosPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.photospage.di.PhotosPageModule
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.view.PostsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.di.PostsPageModule
import com.adrian.project.ui.jsonplaceholder.submodules.todospage.TodosPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.todospage.di.TodosPageModule
import com.adrian.project.ui.jsonplaceholder.submodules.userspage.UsersPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.userspage.di.UsersPageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
abstract class JsonPlaceholderFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(PostsPageModule::class))
    abstract fun bindPostsPageFragment(): PostsPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(AlbumsPageModule::class))
    abstract fun bindAlbumsPageFragment(): AlbumsPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(CommentsPageModule::class))
    abstract fun bindCommentsPageFragment(): CommentsPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(PhotosPageModule::class))
    abstract fun bindPhotosPageFragment(): PhotosPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(TodosPageModule::class))
    abstract fun bindTodosPageFragment(): TodosPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(UsersPageModule::class))
    abstract fun bindUsersPageFragment(): UsersPageFragment

}
