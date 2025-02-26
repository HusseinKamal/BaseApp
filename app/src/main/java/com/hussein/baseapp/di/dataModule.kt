package com.hussein.baseapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.hussein.baseapp.data.local.datastore.local.DataStoreViewModel
import com.hussein.baseapp.data.local.datastore.local.PreferencesManager
import com.hussein.baseapp.domain.repository.DataStoreRepository
import com.hussein.baseapp.domain.repository.DataStoreRepositoryImpl
import com.hussein.baseapp.util.Util.DATA_STORE_LOCAL_NAME
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create(
            produceFile = {
                get<Context>().dataStoreFile(DATA_STORE_LOCAL_NAME)
            }
        )
    }

    single { PreferencesManager(get()) }

    single<DataStoreRepository> { DataStoreRepositoryImpl(get()) }
    viewModel { DataStoreViewModel(get()) }
}