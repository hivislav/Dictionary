package com.hivislav.dictionary.domain

interface Interactor<T> {
    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}