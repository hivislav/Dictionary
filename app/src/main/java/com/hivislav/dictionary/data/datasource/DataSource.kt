package com.hivislav.dictionary.data.datasource

import io.reactivex.Observable

interface DataSource<T> {
    fun getData(word: String): Observable<T>
}