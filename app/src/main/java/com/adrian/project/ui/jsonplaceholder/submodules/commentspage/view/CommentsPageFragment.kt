package com.adrian.project.ui.jsonplaceholder.submodules.commentspage.view

import android.content.Context
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
import com.adrian.project.databinding.FragmentCommentsPageBinding
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.view.CommentsPageFragment.name.TAG
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.viewmodel.CommentsPageViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CommentsPageFragment : Fragment(), CommentsPageRouter {

    @Inject
    lateinit var viewModel: CommentsPageViewModel

    lateinit var binding: FragmentCommentsPageBinding

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.toString()
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        binding?.rvComments?.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun getLayoutId() = R.layout.fragment_comments_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
