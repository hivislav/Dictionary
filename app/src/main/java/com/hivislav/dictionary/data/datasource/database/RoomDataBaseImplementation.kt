package com.hivislav.dictionary.data.datasource.database

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto

class RoomDataBaseImplementation: DataSource<List<DataModelDto>> {
    override suspend fun getData(word: String): List<DataModelDto> {
        TODO("not implemented") // To change body of created functions use File
                                        // | Settings | File Templates.
    }
}
