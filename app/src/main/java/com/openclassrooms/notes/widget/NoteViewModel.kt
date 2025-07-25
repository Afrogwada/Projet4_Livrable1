package com.openclassrooms.notes.widget

import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel that exposes the list of notes to the UI.
 */
class NoteViewModel(private val repository: NotesRepository) : ViewModel() {

    /**
     * Public read-only StateFlow of notes.
     */

    val notes: StateFlow<List<Note>> = repository.notes
}