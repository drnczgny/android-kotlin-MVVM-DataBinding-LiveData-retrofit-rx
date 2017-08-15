package com.adrian.project.ui.jsonplaceholder.submodules.postspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.Post
import rx.Observer

/**
 * Created by cadri on 2017. 08. 15..
 */

interface PostServiceInteractor {

    fun findAll(observer: Observer<List<Post>>)

    fun findById(id: Int)

}