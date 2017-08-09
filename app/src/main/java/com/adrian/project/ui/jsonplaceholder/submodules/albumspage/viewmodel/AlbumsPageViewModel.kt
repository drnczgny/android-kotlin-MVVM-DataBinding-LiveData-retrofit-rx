package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel

import android.databinding.Bindable
import android.util.Log
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
constructor(val model: AlbumsPageModel, val router: AlbumsPageRouter) : BaseViewModel(), AlbumsPageModel.OnAlbumListCallback {

    @Bindable
    var albums: List<ListItemViewModel> = model.testAlbums()
        set(value) {
            if (albums != value && !albums.equals(value)) {
                field = value
                notifyPropertyChanged(BR.albums)
            }
        }

    init {
        model.registerCallback(this)
        model.findAllAlbum()
    }

    override fun onFindAllAlbumSuccess(items: List<AlbumItemViewModel>) {
        albums = items
        Log.i("TAG", items.toString());
    }

    override fun onFindAllAlbumError(t: Throwable) {
        t.printStackTrace()
    }

    fun onClickGetAlbums(view: View) {
        model.findAllAlbum()
    }

    fun onCreateView() {
    }

    fun onDestroy() {
        model.unRegisterCallback()
    }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_album

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

}