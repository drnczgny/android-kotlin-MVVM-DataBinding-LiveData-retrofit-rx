package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel

import android.databinding.Bindable
import android.util.Log
import android.view.View
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.model.CommentsPageModel
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.view.CommentsPageRouter

/**
 * Created by cadri on 2017. 08. 16..
 */

class CommentsPageViewModel constructor(val router: CommentsPageRouter, val model: CommentsPageModel) : BaseViewModel(), CommentsPageModel.OnCommentListCallback {

    @Bindable
    var comments: List<ListItemViewModel> = ArrayList<ListItemViewModel>()
        set(value) {
            if (comments != value && !comments.equals(value)) {
                field = value
                notifyPropertyChanged(BR.comments)
            }
        }

    init {
        model.registerCallback(this)
        model.findAllComment()
    }

    override fun onFindAllCommentSuccess(items: List<CommentItemViewModel>) {
        comments = items
        Log.i("TAG", items.toString());
    }

    override fun onFindAllCommentError(t: Throwable) {
        t.printStackTrace()
    }

    fun onClickGetComments(view: View) {
        model.findAllComment()
    }

    fun onDestroy() {
        model.unRegisterCallback()
    }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_comment

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }
}