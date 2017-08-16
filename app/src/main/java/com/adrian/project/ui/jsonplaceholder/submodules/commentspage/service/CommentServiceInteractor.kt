package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.Comment
import rx.Observer

/**
 * Created by cadri on 2017. 08. 16..
 */

interface CommentServiceInteractor {

    fun findAll(observer: Observer<List<Comment>>)

    fun findById(id: Int)

}