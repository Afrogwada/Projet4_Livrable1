package com.openclassrooms.notes.repository

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository class for the notes.
 */
class NotesRepository @Inject constructor(
    private val notesApiService: NotesApiService
) {

    /**
     * A flow that emits a list of all notes.
     */
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes
    init {
        // Simule une récupération de notes (mock)
        _notes.value= notesApiService.getAllNotes()
    }


}