package com.hussein.baseapp.presentation.productdetails

import com.hussein.baseapp.domain.model.Product

data class ProductListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Product> = emptyList(),
    val favoriteBooks: List<Product> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: String? = null
)