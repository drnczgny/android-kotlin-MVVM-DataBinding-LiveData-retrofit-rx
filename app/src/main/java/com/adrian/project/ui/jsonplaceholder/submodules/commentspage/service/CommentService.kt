package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.Comment
import retrofit2.http.GET
import rx.Observable

/**
 * Created by cadri on 2017. 08. 16..
 */

interface CommentService {

    @GET("/comments")
    fun findAllComment(): Observable<List<Comment>>

}