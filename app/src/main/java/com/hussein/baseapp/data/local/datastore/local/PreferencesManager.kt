package com.hussein.baseapp.data.local.datastore.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesManager(private val dataStore: DataStore<Preferences>) {
    companion object {
        val EXAMPLE_KEY = stringPreferencesKey("example_key")
        val DATASTORE_KEY = "data_key"
    }

    suspend fun saveData(key:String,value: String) {
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    fun getData(key:String): Flow<String> {
        return dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey(key)].toString()
            }
    }
}