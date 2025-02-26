package com.hussein.baseapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveData(key:String,value: String)
    fun getData(key:String): Flow<String>
}