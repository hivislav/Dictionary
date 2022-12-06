package com.hivislav.dictionary.data.datasource.network

import com.hivislav.dictionary.data.datasource.DataSource
import io.reactivex.Observable

class RetrofitImplementation (
    private val apiService: ApiService
) : DataSource<List<DataModelDto>> {

    override fun getData(word: String): Observable<List<DataModelDto>> {
        return apiService.search(word)
    }
}