package com.adrian.project.di

import com.adrian.project.ui.jsonplaceholder.di.JsonPlaceholderModule
import com.adrian.project.ui.jsonplaceholder.di.JsonPlaceholderFragmentBuilderModule
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.di.PostsPageModule
import com.adrian.project.ui.main.JsonPlaceholderActivity
import com.adrian.project.ui.main.view.MainActivity
import com.adrian.project.ui.main.di.MainModule
import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(JsonPlaceholderModule::class, PostsPageModule::class, JsonPlaceholderFragmentBuilderModule::class))
    abstract fun bindJsonPlaceholderActivity(): JsonPlaceholderActivity

}