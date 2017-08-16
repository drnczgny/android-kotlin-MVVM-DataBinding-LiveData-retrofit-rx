package com.adrian.project.ui.jsonplaceholder.submodules.postspage.model

import android.util.Log
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.service.PostServiceInteractor
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.Post
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.PostItemViewModel
import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import rx.Observer

/**
 * Created by cadri on 2017. 08. 05..
 */

class PostsPageModel constructor(val interactor: PostServiceInteractor) {

    object name {
        @JvmStatic val TAG = PostsPageModel::class.java.simpleName
    }

    lateinit var postListObserver: Observer<List<Post>>
    lateinit var postObserver: Observer<Post>

    var callback: OnPostListCallback? = null

    init {
        createPostListObserver()
        createPostObserver()
    }

    fun findAllPost() {
        interactor.findAll(postListObserver)
    }

    fun registerCallback(callback: OnPostListCallback) {
        this.callback = callback
    }

    fun unRegisterCallback() {
        this.callback = null
    }

    private fun convertToViewModel(post: Post) = PostItemViewModel(post)

    private fun convertToViewModels(posts: List<Post>): List<PostItemViewModel>
            = Stream.of(posts).map { post -> convertToViewModel(post) }.collect(Collectors.toList())

    private fun createPostListObserver() {
        postListObserver = object : Observer<List<Post>> {
            override fun onCompleted() {
                Log.i(name.TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(name.TAG, "onError")
                e.printStackTrace()
                callback?.onFindAllPostError(e)
            }

            override fun onNext(posts: List<Post>) {
                Log.i(name.TAG, "onNext")
                callback?.onFindAllPostSuccess(convertToViewModels(posts))
            }
        }
    }

    private fun createPostObserver() {
        postObserver = object : Observer<Post> {
            override fun onCompleted() {
                Log.i(name.TAG, "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i(name.TAG, "onError")
                e.printStackTrace()
            }

            override fun onNext(post: Post) {
                Log.i(name.TAG, "onNext")
                Log.i(name.TAG, post.toString())
            }
        }
    }

    interface OnPostListCallback {

        fun onFindAllPostSuccess(posts: List<PostItemViewModel>)

        fun onFindAllPostError(t: Throwable)

    }
}