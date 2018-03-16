package com.adrian.project.ui.secondpage.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.project.ui.secondpage.view.SecondPageActivity
import com.adrian.project.ui.secondpage.viewmodel.SecondPageViewModel
import dagger.Module
import dagger.Provides

@Module
class SecondPageModule {

    @Provides
    @ActivityScope
    fun providesSecondPageViewModel(activity: SecondPageActivity) = SecondPageViewModel(activity)

}