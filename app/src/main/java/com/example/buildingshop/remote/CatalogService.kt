package com.example.buildingshop.remote

import com.example.buildingshop.remote.models.CatalogItem
import retrofit2.http.GET

interface CatalogService {
    @GET("products?cat_id=1000457&limit=10&offset=0&base_id=1&sort_type=0")
    suspend fun getCatalog(): List<CatalogItem>
}