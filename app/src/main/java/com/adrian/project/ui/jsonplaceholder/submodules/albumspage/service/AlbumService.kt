package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.Album
import retrofit2.http.GET
import rx.Observable

/**
 * Created by cadri on 2017. 08. 06..
 */

interface AlbumService {

    @GET("/albums")
    fun findAllAlbum(): Observable<List<Album>>

}