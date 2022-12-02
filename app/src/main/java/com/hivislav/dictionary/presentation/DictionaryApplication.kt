package com.hivislav.dictionary.presentation

import android.app.Application
import com.hivislav.dictionary.di.DaggerApplicationComponent

class DictionaryApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}