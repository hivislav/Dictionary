package com.hivislav.dictionary.data.datasource.network

import com.hivislav.dictionary.data.datasource.DataSource

class RetrofitImplementation (
    private val apiService: ApiService
) : DataSource<List<DataModelDto>> {

    override suspend fun getData(word: String): List<DataModelDto> {
        return apiService.searchAsync(word).await()
    }
}