package ca.tetervak.petsandfolks.ui.folks

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class FolkDetailsViewModel(
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    val itemId: String = checkNotNull(savedStateHandle["itemId"])
}