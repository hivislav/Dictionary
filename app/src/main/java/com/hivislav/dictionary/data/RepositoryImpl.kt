package com.hivislav.dictionary.data

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto
import com.hivislav.dictionary.domain.Repository

class RepositoryImpl (
    private val remoteDataSource: DataSource<List<DataModelDto>>,
    private val localDataSource: DataSource<List<DataModelDto>>
) : Repository<List<DataModelDto>> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): List<DataModelDto> {
        return if (fromRemoteSource) {
            remoteDataSource.getData(word)
        } else {
            localDataSource.getData(word)
        }
    }
}