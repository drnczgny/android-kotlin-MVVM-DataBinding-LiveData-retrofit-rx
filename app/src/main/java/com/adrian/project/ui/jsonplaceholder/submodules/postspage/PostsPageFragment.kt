package com.adrian.project.ui.jsonplaceholder.submodules.postspage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.R
import com.adrian.project.ui.jsonplaceholder.submodules.photospage.PhotosPageFragment.name.TAG
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PostsPageFragment : Fragment(), PostsPageRouter {

    @Inject
    lateinit var postsPageModel: PostsPageModel

    companion object {
        fun newInstance(): PostsPageFragment {
            val fragment = PostsPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = PostsPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        postsPageModel.callApiService()

        return inflater!!.inflate(R.layout.fragment_posts_page, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
