package com.hivislav.dictionary.data.datasource.database

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto

class DataSourceLocal (
    private val localProvider: RoomDataBaseImplementation
)  : DataSource<List<DataModelDto>> {

    override suspend fun getData(word: String): List<DataModelDto> =
        localProvider.getData(word)
}