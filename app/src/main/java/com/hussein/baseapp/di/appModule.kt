package com.hussein.baseapp.di
import androidx.room.Room
import com.hussein.baseapp.data.local.database.AppDatabase
import com.hussein.baseapp.data.local.datastore.local.DataStoreViewModel
import com.hussein.baseapp.data.remote.ApiService
import com.hussein.baseapp.data.remote.data.HttpClientFactory
import com.hussein.baseapp.data.remote.repository.ProductRepository
import com.hussein.baseapp.data.remote.repository.ProductRepositoryImpl
import com.hussein.baseapp.domain.usecase.DataStoreUseCases
import com.hussein.baseapp.presentation.productdetails.ProductListViewModel
import com.hussein.baseapp.util.Util.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(get()) }
    single { ApiService() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().productDao() } // Get the UserDao
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    factory { DataStoreUseCases(get()) }
    viewModel { ProductListViewModel(get()) }
    //viewModel { RegistrationViewModel(get()) } // Provide RegistrationViewModel with UserRepository

}