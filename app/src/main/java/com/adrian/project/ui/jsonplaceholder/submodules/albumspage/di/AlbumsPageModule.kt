package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.model.AlbumsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.AlbumService
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.AlbumServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.DefaultAlbumServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.view.AlbumsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.view.AlbumsPageRouter
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumsPageViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class AlbumsPageModule {

    @FragmentScope
    @Provides
    fun providesAlbumsPageRouter(albumsPageFragment: AlbumsPageFragment): AlbumsPageRouter = albumsPageFragment

    @FragmentScope
    @Provides
    fun providesAlbumService(@Named("jsonplaceholderapi") retrofit: Retrofit): AlbumService
            = retrofit.create(AlbumService::class.java)

    @FragmentScope
    @Provides
    @Named("DefaultAlbumServiceInteractor")
    fun providesAlbumInteractor(albumService: AlbumService): AlbumServiceInteractor = DefaultAlbumServiceInteractor(albumService)

    @FragmentScope
    @Provides
    fun providesAlbumsPageModel(@Named("DefaultAlbumServiceInteractor") interactor: AlbumServiceInteractor) = AlbumsPageModel(interactor)

    @FragmentScope
    @Provides
    fun providesAlbumsPageViewModel(model: AlbumsPageModel, router: AlbumsPageRouter)
            = AlbumsPageViewModel(model, router)
}