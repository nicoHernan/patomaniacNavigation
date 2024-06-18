package com.example.patomaniaccompose.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patomaniaccompose.data.PatoManiacRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class HomeViewModel @Inject constructor(
    patoManiacRepository: PatoManiacRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow <HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                  listRecipes = patoManiacRepository.getRecipesInformation() ?: ArrayList()
                )
            }
        }
    }
}