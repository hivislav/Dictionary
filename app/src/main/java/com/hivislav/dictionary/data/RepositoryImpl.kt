package com.hivislav.dictionary.data

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto
import com.hivislav.dictionary.domain.Repository
import io.reactivex.Observable

class RepositoryImpl(
    private val dataSource: DataSource<List<DataModelDto>>
): Repository<List<DataModelDto>> {

    override fun getData(word: String): Observable<List<DataModelDto>> {

        return dataSource.getData(word)
    }
}