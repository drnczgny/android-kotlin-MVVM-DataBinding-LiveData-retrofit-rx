package com.adrian.project.ui.jsonplaceholder.submodules.userspage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.R
import com.adrian.project.ui.jsonplaceholder.submodules.userspage.UsersPageFragment.name.TAG
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UsersPageFragment : Fragment(), UsersPageRouter {

    @Inject
    lateinit var usersPageModel: UsersPageModel

    companion object {
        fun newInstance(): UsersPageFragment {
            val fragment = UsersPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = UsersPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usersPageModel.callApiService()

        return inflater!!.inflate(R.layout.fragment_users_page, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
