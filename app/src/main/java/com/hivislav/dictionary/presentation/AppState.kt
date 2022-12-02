package com.hivislav.dictionary.presentation

import com.hivislav.dictionary.data.datasource.network.DataModelDto

sealed class AppState {
    data class Success (val data: List<DataModelDto>?) : AppState()
    data class Error (val error: Throwable) : AppState()
    data class Loading (val progress: Int?) : AppState()
}
