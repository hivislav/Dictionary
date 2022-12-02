package com.hivislav.dictionary.domain

import com.hivislav.dictionary.data.datasource.network.DataModelDto
import com.hivislav.dictionary.presentation.AppState
import io.reactivex.Observable
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val repository: Repository<List<DataModelDto>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return repository.getData(word, fromRemoteSource).map {
            AppState.Success(it)
        }
    }
}
