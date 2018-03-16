package com.adrian.project.ui.secondpage.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.adrian.project.ui.secondpage.view.SecondPageActivity

class SecondPageViewModel constructor(activity: SecondPageActivity) {

    val text = MutableLiveData<String>()

    val editText = MutableLiveData<String>()

    init {

        editText.observe(activity, Observer {
            it.let { text.value = it.toString() }
        })

//        editText.value = "sample text";
//
//        text.value = editText.value
    }

//    @Bindable
//    val text = "sdjfhkf"
//
//    init {
//        Log.e("TAG", "asdkljflksdflé")
//    }

}