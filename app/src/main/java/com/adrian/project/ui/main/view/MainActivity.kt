package com.adrian.project.ui.main.view

import com.adrian.project.ui.main.JsonPlaceholderActivity
import com.adrian.project.ui.main.model.MainModel
import com.adrian.project.ui.secondpage.view.SecondPageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : android.support.v7.app.AppCompatActivity(), MainRouter {

    @javax.inject.Inject
    lateinit var mainModel: MainModel

    lateinit var btnPostsPage: android.widget.Button

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        dagger.android.AndroidInjection.inject(this)
        setContentView(com.adrian.project.R.layout.activity_main)

        mainModel.callApiService()

        btnPostsPage = findViewById(com.adrian.project.R.id.btnPostsPage) as android.widget.Button
        btnPostsPage.setOnClickListener { openPostsPage() }

        btnLiveDataViewModel.setOnClickListener { openLiveDataExamplePage() }
    }

    fun openPostsPage() {
        val intent = android.content.Intent(this, JsonPlaceholderActivity::class.java)
        startActivity(intent)
    }

    /**
     * databinding viewmodel uses livedata instead of baseobservable
     */
    fun openLiveDataExamplePage() {
        val intent = android.content.Intent(this, SecondPageActivity::class.java)
        startActivity(intent)
    }

}
