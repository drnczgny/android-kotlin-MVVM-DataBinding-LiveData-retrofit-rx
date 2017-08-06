package com.adrian.project.ui.jsonplaceholder.submodules.albumspage

import android.util.Log
import com.adrian.project.data.ApiService
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageModel.name.TAG
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumItemViewModel
import rx.Observer

/**
 * Created by cadri on 2017. 08. 05..
 */

class AlbumsPageModel constructor(val apiService: ApiService) {

    object name {
        @JvmStatic val TAG = AlbumsPageModel::class.java.simpleName
    }

    var albumListObserver: Observer<List<Album>>? = null

    var albumObserver: Observer<Album>? = null

    fun findAllAlbum() {
//        albumService.findAllAlbum()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(albumListObserver)
    }

    private fun createAlbumListObserver() {
        albumListObserver = object : Observer<List<Album>> {
            override fun onCompleted() {
                Log.i(TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(TAG, "onError")
                e.printStackTrace()
//                callback.onFindAllAlbumError(e)
            }

            override fun onNext(albums: List<Album>) {
                Log.i(TAG, "onNext")
                Log.i(TAG, albums.toString())
//                callback.onFindAllAlbumSuccess(albums)
            }
        }
    }

    private fun createAlbumObserver() {
        albumObserver = object : Observer<Album> {
            override fun onCompleted() {
                Log.i(TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(TAG, "onError")
                e.printStackTrace()
            }

            override fun onNext(album: Album) {
                Log.i(TAG, "onNext")
                Log.i(TAG, album.toString())
            }
        }
    }

    fun testAlbums(): List<AlbumItemViewModel> {
        return listOf(
                AlbumItemViewModel(Album(1, 1, "title1")),
                AlbumItemViewModel(Album(2, 2, "title2")),
                AlbumItemViewModel(Album(3, 3, "title3")),
                AlbumItemViewModel(Album(4, 4, "title4")))
    }

}