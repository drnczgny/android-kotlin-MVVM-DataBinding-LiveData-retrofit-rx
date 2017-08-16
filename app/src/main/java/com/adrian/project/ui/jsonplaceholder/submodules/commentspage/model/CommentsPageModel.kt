package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.model

import android.util.Log
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.service.CommentServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.Comment
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.CommentItemViewModel
import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import rx.Observer

/**
 * Created by cadri on 2017. 08. 16..
 */

class CommentsPageModel constructor(val interactor: CommentServiceInteractor) {

    object name {
        @JvmStatic
        val TAG = CommentsPageModel::class.java.simpleName
    }

    lateinit var commentListObserver: Observer<List<Comment>>
    lateinit var commentObserver: Observer<Comment>

    var callback: CommentsPageModel.OnCommentListCallback? = null

    init {
        createCommentListObserver()
        createCommentObserver()
    }

    fun findAllComment() {
        interactor.findAll(commentListObserver)
    }

    fun registerCallback(callback: CommentsPageModel.OnCommentListCallback) {
        this.callback = callback
    }

    fun unRegisterCallback() {
        this.callback = null
    }

    private fun convertToViewModel(comment: Comment) = CommentItemViewModel(comment)

    private fun convertToViewModels(comments: List<Comment>): List<CommentItemViewModel>
            = Stream.of(comments).map { comment -> convertToViewModel(comment) }.collect(Collectors.toList())

    private fun createCommentListObserver() {
        commentListObserver = object : Observer<List<Comment>> {
            override fun onCompleted() {
                Log.i(CommentsPageModel.name.TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(CommentsPageModel.name.TAG, "onError")
                e.printStackTrace()
                callback?.onFindAllCommentError(e)
            }

            override fun onNext(comments: List<Comment>) {
                Log.i(CommentsPageModel.name.TAG, "onNext")
                callback?.onFindAllCommentSuccess(convertToViewModels(comments))
            }
        }
    }

    private fun createCommentObserver() {
        commentObserver = object : Observer<Comment> {
            override fun onCompleted() {
                Log.i(CommentsPageModel.name.TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(CommentsPageModel.name.TAG, "onError")
                e.printStackTrace()
            }

            override fun onNext(comment: Comment) {
                Log.i(CommentsPageModel.name.TAG, "onNext")
                Log.i(CommentsPageModel.name.TAG, comment.toString())
            }
        }
    }

    interface OnCommentListCallback {

        fun onFindAllCommentSuccess(comments: List<CommentItemViewModel>)

        fun onFindAllCommentError(t: Throwable)

    }
}