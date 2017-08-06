package com.adrian.project.ui.jsonplaceholder.viewpager

import android.support.v4.app.Fragment
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.AlbumsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.commentspage.CommentsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.photospage.PhotosPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.PostsPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.todospage.TodosPageFragment
import com.adrian.project.ui.jsonplaceholder.submodules.userspage.UsersPageFragment

/**
 * Created by cadri on 2017. 08. 05..
 */

class JsonPlaceholderViewPagerDataModel {

    fun titleList() = listOf<String>("Posts", "Albums", "Comments", "Photos", "Todos", "Users")

    fun fragmentList() = listOf<Fragment>(PostsPageFragment.newInstance(),
            AlbumsPageFragment.newInstance(),
            CommentsPageFragment.newInstance(),
            PhotosPageFragment.newInstance(),
            TodosPageFragment.newInstance(),
            UsersPageFragment.newInstance())
}
