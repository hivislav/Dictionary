package com.hivislav.dictionary.data.datasource

interface DataSource<T> {
    suspend fun getData(word: String): T
}