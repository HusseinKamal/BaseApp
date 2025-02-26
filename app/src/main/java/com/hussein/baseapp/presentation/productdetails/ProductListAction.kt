package com.hussein.baseapp.presentation.productdetails

import com.hussein.baseapp.domain.model.Product

sealed interface ProductListAction {
    data class OnSearchQueryChange(val query: String) : ProductListAction
    data class OnBookClick(val book: Product) : ProductListAction
    data class OnTabSelected(val index: Int) : ProductListAction
}