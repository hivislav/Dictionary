package com.hivislav.dictionary.presentation

import android.app.Application
import com.hivislav.dictionary.di.application
import com.hivislav.dictionary.di.mainScreen
import org.koin.core.context.startKoin

class DictionaryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(listOf(application, mainScreen)) }
    }
}