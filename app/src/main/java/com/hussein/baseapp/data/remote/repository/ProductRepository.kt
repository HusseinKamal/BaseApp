package com.hussein.baseapp.data.remote.repository

import com.hussein.baseapp.data.remote.Result
import com.hussein.baseapp.data.remote.data.DataError
import com.hussein.baseapp.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductList(): Flow<Result<Product,DataError.Remote>>
}