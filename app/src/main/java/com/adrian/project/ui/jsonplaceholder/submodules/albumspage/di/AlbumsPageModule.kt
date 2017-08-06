package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.di

import com.adrian.project.data.ApiService
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageRouter
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumsPageViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class AlbumsPageModule {

    @FragmentScope
    @Provides
    fun providesAlbumsPageRouter(albumsPageFragment: AlbumsPageFragment): AlbumsPageRouter = albumsPageFragment

//    @FragmentScope
//    @Provides
//    fun providesAlbumsService(retrofit: Retrofit): AlbumService {
//        val albumService = retrofit.create(AlbumService::class.java)
//        return albumService
//    }

    @FragmentScope
    @Provides
    fun providesAlbumsPageModel(apiService: ApiService) = AlbumsPageModel(apiService)

    @FragmentScope
    @Provides
    fun providesAlbumsPageViewModel(albumsPageModel: AlbumsPageModel, albumsPageRouter: AlbumsPageRouter)
            = AlbumsPageViewModel(albumsPageModel, albumsPageRouter)
}