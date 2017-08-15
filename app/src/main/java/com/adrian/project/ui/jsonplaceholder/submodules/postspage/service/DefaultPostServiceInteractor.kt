package com.adrian.project.ui.jsonplaceholder.submodules.postspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.Post
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DefaultPostServiceInteractor constructor(val postService: PostService): PostServiceInteractor {

    object name {
        @JvmStatic val TAG = DefaultPostServiceInteractor::class.java.simpleName
    }

    override fun findAll(observer: Observer<List<Post>>) {

        postService.findAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    override fun findById(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}