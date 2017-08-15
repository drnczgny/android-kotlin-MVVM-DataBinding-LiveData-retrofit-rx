package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DefaultAlbumServiceInteractor constructor(val albumService: AlbumService) : AlbumServiceInteractor {
    object name {

        @JvmStatic val TAG = DefaultAlbumServiceInteractor::class.java.simpleName
    }
//    lateinit var albumListObserver: Observer<List<Album>>
//
//    lateinit var albumObserver: Observer<Album>


    init {
    }

//    override fun findAll() {
//        albumService.findAllAlbum()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(albumListObserver)
//    }

    override fun findAll(observer: Observer<List<Album>>) {
        albumService.findAllAlbum()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    override fun findById(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
