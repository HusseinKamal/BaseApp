package com.hussein.baseapp.data.local.database

import com.hussein.baseapp.domain.model.Product

fun Product.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = id.toInt(),
        name = name,
        sku = sku
    )
}

fun ProductEntity.toProductEntity(): Product {
    return Product(
        id = id.toString(),
        name = name,
        sku = sku
    )
}
