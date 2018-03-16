package com.adrian.project.di

import com.adrian.project.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 03..
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityBuilderModule::class, NetworkModule::class, AndroidSupportInjectionModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(myApplication: MyApplication): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)
}