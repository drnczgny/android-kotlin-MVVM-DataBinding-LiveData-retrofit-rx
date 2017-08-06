package com.adrian.project.ui.jsonplaceholder.submodules.albumspage

import com.adrian.project.data.ApiService
import com.adrian.project.ui.jsonplaceholder.submodules.albumspage.viewmodel.AlbumItemViewModel

/**
 * Created by cadri on 2017. 08. 05..
 */

class AlbumsPageModel constructor(val apiService: ApiService) {

    fun callApiService() = apiService.fakeApiCall()

    fun testAlbums(): List<AlbumItemViewModel> {
        return listOf(
                AlbumItemViewModel("1", "title1"),
                AlbumItemViewModel("2", "title2"),
                AlbumItemViewModel("3", "title3"),
                AlbumItemViewModel("4", "title4"))
    }

}