package com.hussein.baseapp.domain.usecase

import com.hussein.baseapp.domain.repository.DataStoreRepository

class DataStoreUseCases(
    private val repository: DataStoreRepository
) {
    suspend fun saveData(key:String,value: String) = repository.saveData(key,value)
    fun getData(key:String) = repository.getData(key)
}