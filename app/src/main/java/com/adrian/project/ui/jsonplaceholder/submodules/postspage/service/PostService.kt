package com.adrian.project.ui.jsonplaceholder.submodules.postspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.Post
import retrofit2.http.GET
import rx.Observable

/**
 * Created by cadri on 2017. 08. 15..
 */

interface PostService {

    @GET("/posts")
    fun findAllPost(): Observable<List<Post>>

}