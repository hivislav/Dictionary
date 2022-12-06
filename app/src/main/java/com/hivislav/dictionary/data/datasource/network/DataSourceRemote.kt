package com.hivislav.dictionary.data.datasource.network

import com.hivislav.dictionary.data.datasource.DataSource

class DataSourceRemote (
    private val remoteProvider: RetrofitImplementation
) : DataSource<List<DataModelDto>> {

    override suspend fun getData(word: String): List<DataModelDto> =
        remoteProvider.getData(word)
}