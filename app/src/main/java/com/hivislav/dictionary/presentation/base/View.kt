package com.hivislav.dictionary.presentation.base

import com.hivislav.dictionary.presentation.AppState

interface View {

    fun renderData(appState: AppState)
}