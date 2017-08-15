package com.adrian.project.ui.jsonplaceholder.submodules.postspage.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.databinding.FragmentPostsPageBinding
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.view.PostsPageFragment.name.TAG
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.viewmodel.PostsPageViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PostsPageFragment : Fragment(), PostsPageRouter {

    @Inject
    lateinit var viewModel: PostsPageViewModel

    lateinit var binding: FragmentPostsPageBinding

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
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        binding?.rvPosts?.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }


    fun getLayoutId() = R.layout.fragment_posts_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
