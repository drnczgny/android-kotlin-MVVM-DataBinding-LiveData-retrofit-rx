package com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 15..
 */

class PostItemViewModel(val post: Post) : ListItemViewModel() {

    @Bindable
    var id = post.id

    @Bindable
    var userId = post.userId

    @Bindable
    var title = post.title

    @Bindable
    var body = post.body
        set(value) {
            if (!value.equals(body)) {
                field = value
                notifyPropertyChanged(BR.body)
            }
        }

    override fun toString(): String {
        return "PostItemViewModel(post=$post)"
    }
}