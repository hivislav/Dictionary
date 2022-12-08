package com.hivislav.dictionary.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hivislav.dictionary.domain.MainInteractor
import com.hivislav.dictionary.presentation.AppState
import kotlinx.coroutines.*


class MainViewModel(
    private val interactor: MainInteractor
    ) : ViewModel() {

    private val _loadedWords = MutableLiveData<AppState>()
    val loadedWords: LiveData<AppState>
        get() = _loadedWords

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    fun getData(word: String, isOnline: Boolean) {
        _loadedWords.value = AppState.Loading(null)
        cancelJob()

        viewModelCoroutineScope.launch {
            startInteractor(word, isOnline)
        }
    }

    private fun handleError(error: Throwable) {
        _loadedWords.postValue(AppState.Error(error))
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _loadedWords.postValue(interactor.getData(word, isOnline))
        }

    private fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        _loadedWords.value = AppState.Success(null)
        super.onCleared()
        cancelJob()
    }
}