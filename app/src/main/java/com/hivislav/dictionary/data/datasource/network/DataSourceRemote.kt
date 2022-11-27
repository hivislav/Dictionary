package com.hivislav.dictionary.data.datasource.network

import com.hivislav.dictionary.data.datasource.DataSource
import io.reactivex.Observable

class DataSourceRemote(
    private val remoteProvider: RetrofitImplementation = RetrofitImplementation()
) : DataSource<List<DataModelDto>> {

    override fun getData(word: String): Observable<List<DataModelDto>> =
        remoteProvider.getData(word)
}