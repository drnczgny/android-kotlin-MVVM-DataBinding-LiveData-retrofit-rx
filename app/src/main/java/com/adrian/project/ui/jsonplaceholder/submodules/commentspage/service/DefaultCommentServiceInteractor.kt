package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service

import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.Comment
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by cadri on 2017. 08. 16..
 */

class DefaultCommentServiceInteractor constructor(val service: CommentService): CommentServiceInteractor {

    object name {
        @JvmStatic val TAG = DefaultCommentServiceInteractor::class.java.simpleName
    }


    override fun findAll(observer: Observer<List<Comment>>) {
        service.findAllComment()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    override fun findById(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}