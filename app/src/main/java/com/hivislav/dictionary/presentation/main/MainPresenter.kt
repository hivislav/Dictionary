package com.hivislav.dictionary.presentation.main

import com.hivislav.dictionary.presentation.AppState
import com.hivislav.dictionary.presentation.base.View

interface MainPresenter<T : AppState, V : View> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}
