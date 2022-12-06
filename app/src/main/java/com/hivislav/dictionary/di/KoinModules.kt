package com.hivislav.dictionary.di

import com.hivislav.dictionary.data.RepositoryImpl
import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.database.DataSourceLocal
import com.hivislav.dictionary.data.datasource.database.RoomDataBaseImplementation
import com.hivislav.dictionary.data.datasource.network.*
import com.hivislav.dictionary.domain.MainInteractor
import com.hivislav.dictionary.domain.Repository
import com.hivislav.dictionary.presentation.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {

    single<DataSource<List<DataModelDto>>>(named("NAME_REMOTE")) {
        DataSourceRemote(RetrofitImplementation(ApiFactory(BaseInterceptor()).apiService))
    }

    single<DataSource<List<DataModelDto>>>(named("NAME_LOCAL")) {
        DataSourceLocal(RoomDataBaseImplementation())
    }

    single<Repository<List<DataModelDto>>> {
        RepositoryImpl(get(named("NAME_REMOTE")), get(named("NAME_LOCAL")))
    }
}

val mainScreen = module {
    factory { MainInteractor(get()) }
    factory { MainViewModel(get()) }
}
