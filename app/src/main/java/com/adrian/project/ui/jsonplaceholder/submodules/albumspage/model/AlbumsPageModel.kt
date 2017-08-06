package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.model

import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.AlbumInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.DefaultAlbumInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumItemViewModel
import rx.Observer

/**
 * Created by cadri on 2017. 08. 05..
 */

class AlbumsPageModel constructor(val albumInteractor: AlbumInteractor) : DefaultAlbumInteractor.OnAlbumListCallback {

    object name {
        @JvmStatic val TAG = AlbumsPageModel::class.java.simpleName
    }

    var albumListObserver: Observer<List<Album>>? = null

    var albumObserver: Observer<Album>? = null

    fun findAllAlbum() {
        albumInteractor.findAll()
    }

    fun testAlbums(): List<AlbumItemViewModel> {
        return listOf(
                AlbumItemViewModel(Album(1, 1, "title1")),
                AlbumItemViewModel(Album(2, 2, "title2")),
                AlbumItemViewModel(Album(3, 3, "title3")),
                AlbumItemViewModel(Album(4, 4, "title4")))
    }

    override fun onFindAllAlbumSuccess(albums: List<Album>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFindAllAlbumError(t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}