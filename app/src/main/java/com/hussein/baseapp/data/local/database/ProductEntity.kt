package com.hussein.baseapp.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product") // Specify the table name here
data class ProductEntity(@PrimaryKey val id: Int, var name: String?,var sku:String?)