package com.hivislav.dictionary.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hivislav.dictionary.presentation.AppState
import com.hivislav.dictionary.presentation.main.MainPresenter

abstract class BaseActivity<T: AppState>: AppCompatActivity(), View {

    protected lateinit var mainPresenter: MainPresenter<T, View>
    protected abstract fun createPresenter(): MainPresenter<T, View>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainPresenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachView(this)
    }
}