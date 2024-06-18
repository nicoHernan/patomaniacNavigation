package com.example.patomaniaccompose.features.details

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
class DetailsViewModel @Inject constructor(
    patoManiacRepository: PatoManiacRepository
) : ViewModel() {

    private val _detailState = MutableStateFlow(DetailsUiState())
    val detailState: StateFlow<DetailsUiState> = _detailState

    init {
        viewModelScope.launch {

            _detailState.update {

                it.copy(
                    listOfDetails = patoManiacRepository.getRecipesInformation() ?: ArrayList()
                )
            }
        }
    }
}