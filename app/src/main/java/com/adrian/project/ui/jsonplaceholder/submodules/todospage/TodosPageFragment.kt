package com.adrian.project.ui.jsonplaceholder.submodules.todospage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.R
import com.adrian.project.ui.jsonplaceholder.submodules.todospage.TodosPageFragment.name.TAG
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TodosPageFragment : Fragment(), TodosPageRouter {

    @Inject
    lateinit var todosPageModel: TodosPageModel

    companion object {
        fun newInstance(): TodosPageFragment {
            val fragment = TodosPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = TodosPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        todosPageModel.callApiService()

        return inflater!!.inflate(R.layout.fragment_todos_page, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
