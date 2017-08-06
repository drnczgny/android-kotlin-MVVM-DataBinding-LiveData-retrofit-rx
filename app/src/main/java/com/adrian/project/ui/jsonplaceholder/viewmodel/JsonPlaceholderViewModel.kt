package com.adrian.project.ui.jsonplaceholder.viewmodel

import com.adrian.project.base.BaseViewModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.JsonPlaceholderModel
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.JsonPlaceholderRouter

/**
 * Created by cadri on 2017. 08. 05..
 */

class JsonPlaceholderViewModel constructor(val jsonPlaceholderModel: JsonPlaceholderModel,
                                           val jsonPlaceholderRouter: JsonPlaceholderRouter) : BaseViewModel() {

//    @Bindable
//    fun getItemLayoutId() = R.layout.activity_json_placeholder

//    @Bindable
//    fun getVariableId(): Int {
//        return BR.viewModel
//    }

}