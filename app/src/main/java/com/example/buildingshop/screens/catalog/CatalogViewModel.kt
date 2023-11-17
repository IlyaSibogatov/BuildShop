package com.example.buildingshop.screens.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buildingshop.remote.CatalogService
import com.example.buildingshop.remote.models.CatalogItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val service: CatalogService
) : ViewModel() {

    private val _uiState = MutableStateFlow(CatalogUIState())
    val uiState: StateFlow<CatalogUIState> = _uiState


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = uiState.value.copy(
                isLoading = true
            )
            service.getCatalog().let {
                _uiState.value = uiState.value.copy(
                    list = it
                )
            }
            _uiState.value = uiState.value.copy(
                isLoading = true
            )
        }
    }
}