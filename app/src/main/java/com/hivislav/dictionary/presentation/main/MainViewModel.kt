package com.hivislav.dictionary.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hivislav.dictionary.domain.MainInteractor
import com.hivislav.dictionary.presentation.AppState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class MainViewModel (
    private val interactor: MainInteractor,
    private val compositeDisposable: CompositeDisposable,

    ) : ViewModel() {

    private val _loadedWords = MutableLiveData<AppState>()
    val loadedWords: LiveData<AppState>
        get() = _loadedWords

    fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _loadedWords.postValue(AppState.Loading(null))
                }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {
            override fun onNext(appState: AppState) {
                _loadedWords.value = appState
            }

            override fun onError(e: Throwable) {
                _loadedWords.postValue(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}