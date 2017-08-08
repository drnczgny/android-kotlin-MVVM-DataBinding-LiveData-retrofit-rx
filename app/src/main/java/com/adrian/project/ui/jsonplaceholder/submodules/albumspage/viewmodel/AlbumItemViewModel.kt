package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel

import android.databinding.ObservableField
import com.adrian.project.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 06..
 */

class AlbumItemViewModel(var album: Album) : ListItemViewModel() {

    var id = album.id
    var userId = album.userId
    var title : ObservableField<String> = ObservableField(album.title)

    override fun toString(): String {
        return "AlbumItemViewModel(album=$album)"
    }

}