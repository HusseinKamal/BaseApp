package com.hussein.baseapp.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Replace if a user with the same ID already exists
    suspend fun insert(product: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(product: List<ProductEntity>)


    @Update
    suspend fun update(product: ProductEntity)

    @Delete
    suspend fun delete(product: ProductEntity)

    @Query("DELETE FROM product") // Assumes your table name is "users"
    suspend fun deleteAllProducts()


    @Query("SELECT * FROM product WHERE id = :userId")
    suspend fun getProductById(userId: Int): ProductEntity? // Returns null if not found


    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<ProductEntity>> // Use Flow for observing changes



    @Query("SELECT * FROM product WHERE name LIKE '%' || :searchQuery || '%'")
    fun searchProductByName(searchQuery: String): Flow<List<ProductEntity>>
}