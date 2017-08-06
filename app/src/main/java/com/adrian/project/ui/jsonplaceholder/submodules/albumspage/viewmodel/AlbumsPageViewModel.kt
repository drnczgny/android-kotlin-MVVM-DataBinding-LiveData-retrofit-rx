package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel

import android.databinding.Bindable
import android.view.View
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.model.AlbumsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.view.AlbumsPageRouter

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

    fun onClickGetAlbums(view: View) {
        albumsPageModel.findAllAlbum()
    }

}