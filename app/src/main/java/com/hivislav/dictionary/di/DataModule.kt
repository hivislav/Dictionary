package com.hivislav.dictionary.di

import com.hivislav.dictionary.data.RepositoryImpl
import com.hivislav.dictionary.data.datasource.DataSource
import com.hivislav.dictionary.data.datasource.database.DataSourceLocal
import com.hivislav.dictionary.data.datasource.network.*
import com.hivislav.dictionary.domain.Interactor
import com.hivislav.dictionary.domain.MainInteractor
import com.hivislav.dictionary.domain.Repository
import com.hivislav.dictionary.presentation.AppState
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

@Module
interface DataModule {

    @Named("RemoteDataSource")
    @Binds
    fun bindRemoteDataSource(impl: DataSourceRemote): DataSource<List<DataModelDto>>

    @Named("LocalDataSource")
    @Binds
    fun bindLocalDataSource(impl: DataSourceLocal): DataSource<List<DataModelDto>>

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository<List<DataModelDto>>

    @Binds
    fun bindInteractor(impl: MainInteractor): Interactor<AppState>


    companion object {

        @Provides
        fun provideCompositeDisposable(): CompositeDisposable {
            return CompositeDisposable()
        }

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory(BaseInterceptor()).apiService
        }
    }
}