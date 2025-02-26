package com.hussein.baseapp.data.local.datastore.local

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.baseapp.domain.usecase.DataStoreUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// MainViewModel.kt
class DataStoreViewModel(
    private val dataStoreUseCases: DataStoreUseCases
) : ViewModel() {

    fun saveData(key:String,value: String) {
        viewModelScope.launch {
            dataStoreUseCases.saveData(key,value)
        }
    }

    fun getData(key:String): Flow<String> = dataStoreUseCases.getData(key)
}