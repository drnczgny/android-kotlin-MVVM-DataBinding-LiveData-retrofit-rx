package com.adrian.project.ui.secondpage.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.adrian.project.ui.secondpage.view.SecondPageActivity

class SecondPageViewModel constructor(activity: SecondPageActivity) {

    val text = MutableLiveData<String>()

    val editText = MutableLiveData<String>()

    init {
        setupEditTextObserving(activity)
    }

    private fun setupEditTextObserving(activity: SecondPageActivity) {
        editText.observe(activity, Observer {
            it.let { updateEditText(it) }
        })
    }

    private fun updateEditText(it: String?) {
        text.postValue(it.toString())
    }
}