package com.hussein.baseapp.domain.repository

import com.hussein.baseapp.data.local.datastore.local.PreferencesManager
import kotlinx.coroutines.flow.Flow

class DataStoreRepositoryImpl(
    private val preferencesManager: PreferencesManager
) : DataStoreRepository {

    override suspend fun saveData(key:String,value: String) {
        preferencesManager.saveData(key,value)
    }

    override fun getData(key:String): Flow<String> {
        return preferencesManager.getData(key)
    }
}