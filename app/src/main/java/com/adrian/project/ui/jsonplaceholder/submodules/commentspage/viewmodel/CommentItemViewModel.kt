package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 16..
 */

class CommentItemViewModel constructor(val comment: Comment): ListItemViewModel() {

    @Bindable
    var id = comment.id

    @Bindable
    var postId = comment.postId

    @Bindable
    var name = comment.name

    @Bindable
    var email = comment.email

    @Bindable
    var body = comment.body
        set(value) {
            if (!body.equals(value)) {
                field = value
                notifyPropertyChanged(BR.body)
            }
        }

    override fun toString(): String {
        return super.toString()
    }
}