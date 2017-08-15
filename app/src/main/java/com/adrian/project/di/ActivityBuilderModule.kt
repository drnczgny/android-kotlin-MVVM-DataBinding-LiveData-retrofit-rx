package com.adrian.project.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.project.ui.jsonplaceholder.di.JsonPlaceholderFragmentBuilderModule
import com.adrian.project.ui.jsonplaceholder.di.JsonPlaceholderModule
import com.adrian.project.ui.main.JsonPlaceholderActivity
import com.adrian.project.ui.main.di.MainModule
import com.adrian.project.ui.main.view.MainActivity
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
    @ContributesAndroidInjector(modules = arrayOf(JsonPlaceholderModule::class, JsonPlaceholderFragmentBuilderModule::class))
    abstract fun bindJsonPlaceholderActivity(): JsonPlaceholderActivity

}