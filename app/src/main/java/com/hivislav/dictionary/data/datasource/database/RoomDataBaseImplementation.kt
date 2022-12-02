package com.hivislav.dictionary.data.datasource.database

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto
import io.reactivex.Observable
import javax.inject.Inject

class RoomDataBaseImplementation @Inject constructor() : DataSource<List<DataModelDto>> {
    override fun getData(word: String): Observable<List<DataModelDto>> {
        TODO("not implemented") // To change body of created functions use File
                                        // | Settings | File Templates.
    }
}
