package com.hivislav.dictionary.domain

interface Repository<T> {

   suspend fun getData(word: String, fromRemoteSource: Boolean): T
}