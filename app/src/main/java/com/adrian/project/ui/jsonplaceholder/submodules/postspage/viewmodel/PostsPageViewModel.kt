package com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel

import android.databinding.Bindable
import android.util.Log
import android.view.View
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.model.PostsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.view.PostsPageRouter

/**
 * Created by cadri on 2017. 08. 15..
 */

class PostsPageViewModel constructor(val model: PostsPageModel, val router: PostsPageRouter) : BaseViewModel(), PostsPageModel.OnPostListCallback {

    @Bindable
    var posts: List<ListItemViewModel> = ArrayList<ListItemViewModel>()
        set(value) {
            if (posts != value && !posts.equals(value)) {
                field = value
                notifyPropertyChanged(BR.posts)
            }
        }

    init {
        model.registerCallback(this)
//        model.findAllComment()
    }

    override fun onFindAllPostSuccess(items: List<PostItemViewModel>) {
        posts = items
        Log.i("TAG", items.toString());
    }

    override fun onFindAllPostError(t: Throwable) {
        t.printStackTrace()
    }

    fun onClickGetPosts(view: View) {
        model.findAllPost()
    }

    fun onDestroy() {
        model.unRegisterCallback()
    }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_post

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }
}