package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.model

import android.util.Log
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.AlbumServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumItemViewModel
import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import rx.Observer

/**
 * Created by cadri on 2017. 08. 05..
 */

class AlbumsPageModel constructor(val interactor: AlbumServiceInteractor) {

    object name {
        @JvmStatic val TAG = AlbumsPageModel::class.java.simpleName
    }

    lateinit var albumListObserver: Observer<List<Album>>
    lateinit var albumObserver: Observer<Album>

    var callback: OnAlbumListCallback? = null

    init {
        createAlbumListObserver()
        createAlbumObserver()
    }

    fun findAllAlbum() {
        interactor.findAll(albumListObserver)
    }

    fun testAlbums(): List<AlbumItemViewModel> {
        return listOf(
                AlbumItemViewModel(Album(1, 1, "title1")),
                AlbumItemViewModel(Album(2, 2, "title2")),
                AlbumItemViewModel(Album(3, 3, "title3")),
                AlbumItemViewModel(Album(4, 4, "title4")))
    }

    fun registerCallback(callback: OnAlbumListCallback) {
        this.callback = callback
    }

    fun unRegisterCallback() {
        this.callback = null
    }

    private fun convertToViewModel(album: Album) = AlbumItemViewModel(album)

    private fun convertToViewModel(albums: List<Album>): List<AlbumItemViewModel>
            = Stream.of(albums.map { album -> convertToViewModel(album) }).collect(Collectors.toList())

    private fun createAlbumListObserver() {
        albumListObserver = object : Observer<List<Album>> {
            override fun onCompleted() {
                Log.i(AlbumsPageModel.name.TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(AlbumsPageModel.name.TAG, "onError")
                e.printStackTrace()
                callback?.onFindAllAlbumError(e)
            }

            override fun onNext(albums: List<Album>) {
                Log.i(AlbumsPageModel.name.TAG, "onNext")
                callback?.onFindAllAlbumSuccess(convertToViewModel(albums))
            }
        }
    }

    private fun createAlbumObserver() {
        albumObserver = object : Observer<Album> {
            override fun onCompleted() {
                Log.i(AlbumsPageModel.name.TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(AlbumsPageModel.name.TAG, "onError")
                e.printStackTrace()
            }

            override fun onNext(album: Album) {
                Log.i(AlbumsPageModel.name.TAG, "onNext")
                Log.i(AlbumsPageModel.name.TAG, album.toString())
            }
        }
    }

    interface OnAlbumListCallback {

        fun onFindAllAlbumSuccess(albums: List<AlbumItemViewModel>)

        fun onFindAllAlbumError(t: Throwable)

    }
}