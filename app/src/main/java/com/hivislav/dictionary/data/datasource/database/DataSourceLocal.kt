package com.hivislav.dictionary.data.datasource.database

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto
import io.reactivex.Observable
import javax.inject.Inject

class DataSourceLocal @Inject constructor(
    private val remoteProvider: RoomDataBaseImplementation
)  : DataSource<List< @JvmSuppressWildcards DataModelDto>> {

    override fun getData(word: String): Observable<List<DataModelDto>> =
        remoteProvider.getData(word)
}