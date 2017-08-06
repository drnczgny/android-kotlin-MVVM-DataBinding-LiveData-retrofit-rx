package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service

import android.util.Log
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service.DefaultAlbumInteractor.name.TAG
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DefaultAlbumInteractor constructor(val albumService: AlbumService) : AlbumInteractor {

    object name {
        @JvmStatic val TAG = DefaultAlbumInteractor::class.java.simpleName
    }

    lateinit var albumListObserver: Observer<List<Album>>

    lateinit var albumObserver: Observer<Album>

    var callback: OnAlbumListCallback? = null

    init {
        createAlbumListObserver()
        createAlbumObserver()
    }

    override fun findAll() {

        albumService.findAllAlbum()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albumListObserver)
    }

    override fun findById(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun registerCallback(callback: OnAlbumListCallback) {
        this.callback = callback
    }

    fun unRegisterCallback() {
        this.callback = null
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

    interface OnAlbumListCallback {

        fun onFindAllAlbumSuccess(albums: List<Album>)

        fun onFindAllAlbumError(t: Throwable)

    }
}
