package com.hivislav.dictionary.data.datasource.network

import com.hivislav.dictionary.data.datasource.DataSource
import io.reactivex.Observable
import javax.inject.Inject

class DataSourceRemote @Inject constructor(
    private val remoteProvider: RetrofitImplementation
) : DataSource<List< @JvmSuppressWildcards DataModelDto>> {

    override fun getData(word: String): Observable<List<DataModelDto>> =
        remoteProvider.getData(word)
}