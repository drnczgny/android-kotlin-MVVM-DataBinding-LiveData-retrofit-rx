package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 06..
 */

class AlbumItemViewModel(var album: Album) : ListItemViewModel() {

    @Bindable
    var id = album.id

    @Bindable
    var userId = album.userId

    @Bindable
    var title = album.title
    set(value) {
        if(title != value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
    }

    override fun toString(): String {
        return "AlbumItemViewModel(album=$album)"
    }

}