package com.adrian.project.ui.jsonplaceholder.submodules.albumspage.view

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
import com.adrian.project.databinding.FragmentAlbumsPageBinding
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.view.AlbumsPageFragment.name.TAG
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumsPageViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class AlbumsPageFragment : Fragment(), AlbumsPageRouter {

    @Inject
    lateinit var viewModel: AlbumsPageViewModel

    lateinit var binding: FragmentAlbumsPageBinding

    companion object {
        fun newInstance(): AlbumsPageFragment {
            val fragment = AlbumsPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = AlbumsPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.onCreateView()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_albums_page, container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        binding?.rvAlbums?.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))

        return view
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    fun getLayoutId() = R.layout.fragment_albums_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
