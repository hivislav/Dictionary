package com.hivislav.dictionary.domain

import com.hivislav.dictionary.data.datasource.network.DataModelDto
import com.hivislav.dictionary.presentation.AppState

class MainInteractor (
    private val repository: Repository<List<DataModelDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            repository.getData(word, fromRemoteSource)
        )
    }
}
