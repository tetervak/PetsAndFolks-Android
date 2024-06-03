package ca.tetervak.petsandfolks.ui.pets

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class PetDetailsViewModel(
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    val itemId: String = checkNotNull(savedStateHandle["itemId"])
}