package com.hivislav.dictionary.domain

import io.reactivex.Observable

interface Repository<T> {

    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}