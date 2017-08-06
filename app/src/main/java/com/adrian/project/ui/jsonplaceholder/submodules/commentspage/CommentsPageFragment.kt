package com.adrian.project.ui.jsonplaceholder.submodules.commentspage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.R
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.CommentsPageFragment.name.TAG
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CommentsPageFragment : Fragment(), CommentsPageRouter {

    @Inject
    lateinit var commentsPageModel: CommentsPageModel

    companion object {
        fun newInstance(): CommentsPageFragment {
            val fragment = CommentsPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = CommentsPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        commentsPageModel.callApiService()

        return inflater!!.inflate(R.layout.fragment_comments_page, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
