package com.example.patomaniaccompose.features.similar

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
class SimilarViewModel @Inject constructor(
    patoManiacRepository: PatoManiacRepository
): ViewModel (){

    private val _similarState = MutableStateFlow (SimilarUiState() )
    val similarUiState: StateFlow <SimilarUiState> = _similarState

    init {

        viewModelScope.launch {

            _similarState.update {
                it.copy(
                    listSimilarRecipes = patoManiacRepository.getRecipesSimilarInformation() ?: ArrayList()
                )
            }
        }
    }
}