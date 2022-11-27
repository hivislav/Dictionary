package com.hivislav.dictionary.domain

import com.hivislav.dictionary.data.datasource.network.DataModelDto
import com.hivislav.dictionary.presentation.AppState
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModelDto>>,
    private val localRepository: Repository<List<DataModelDto>>
): Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map {
                AppState.Success(it)
            }
        } else {
            localRepository.getData(word).map {
                AppState.Success(it)
            }
        }
    }
}