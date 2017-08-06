package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 06..
 */

class AlbumItemViewModel(var album: Album) : ListItemViewModel() {

//    var id = album.id
//    var userId = album.userId
//    var title = album.title


    var id: Int
        @Bindable get() = album.id
        set(value) {
            id = value
            notifyPropertyChanged(BR.id)
        }

    var userId: Int
        @Bindable get() = album.userId
        set(value) {
            userId= value
            notifyPropertyChanged(BR.userId)
        }

    var title: String
        @Bindable get() = album.title
        set(value) {
            title = value
            notifyPropertyChanged(BR.title)
        }

    override fun toString(): String {
        return "AlbumItemViewModel(album=$album)"
    }


}