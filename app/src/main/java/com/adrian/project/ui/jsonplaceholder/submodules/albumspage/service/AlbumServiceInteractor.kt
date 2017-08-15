package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import rx.Observer

/**
 * Created by cadri on 2017. 08. 06..
 */

interface AlbumServiceInteractor {

    fun findAll(observer: Observer<List<Album>>)

    fun findById(id: Int)

}
