package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageRouter

/**
 * Created by cadri on 2017. 08. 06..
 */

class AlbumsPageViewModel
constructor(val albumsPageModel: AlbumsPageModel, val albumsPageRouter: AlbumsPageRouter) : BaseViewModel() {

    var albums: List<ListItemViewModel> = albumsPageModel.testAlbums()
//    var albums: List<ListItemViewModel> = ArrayList()

//        @Bindable get() = albums
//        set(value) {
//            albums = value
//            notifyPropertyChanged(BR.albums)
//        }

//    init {
//        albums = testAlbums()
//    }

//    val albums by lazy {
//        testAlbums()
//    }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_album

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

    fun testAlbums(): List<AlbumItemViewModel> {
        return listOf(
                AlbumItemViewModel("1", "title1"),
                AlbumItemViewModel("2", "title2"),
                AlbumItemViewModel("3", "title3"),
                AlbumItemViewModel("4", "title4"))
    }

}