package com.hivislav.dictionary.data

import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.network.DataModelDto
import com.hivislav.dictionary.domain.Repository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class RepositoryImpl @Inject constructor(
    @Named("RemoteDataSource")
    private val remoteDataSource: @JvmSuppressWildcards DataSource<List<DataModelDto>>,
    @Named("LocalDataSource")
    private val localDataSource: @JvmSuppressWildcards DataSource<List<DataModelDto>>
) : Repository<List<@JvmSuppressWildcards DataModelDto>> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<List<DataModelDto>> {
        return if (fromRemoteSource) {
            remoteDataSource.getData(word)
        } else {
            localDataSource.getData(word)
        }
    }
}