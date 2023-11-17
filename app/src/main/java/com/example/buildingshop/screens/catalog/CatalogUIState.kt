package com.example.buildingshop.screens.catalog

import com.example.buildingshop.remote.models.CatalogItem

data class CatalogUIState(
    val isLoading: Boolean = false,
    val list: List<CatalogItem> = listOf()
)
