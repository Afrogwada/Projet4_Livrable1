package com.openclassrooms.notes.widget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel that exposes the list of notes to the UI.
 */
@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    init {
        loadNotes()
    }

    /**
     * Public read-only StateFlow of notes.
     */

    private fun loadNotes() {
        viewModelScope.launch {
            repository.notes.collect {
                _notes.value = it
            }
        }
    }
}