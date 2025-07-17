package com.openclassrooms.notes.widget

import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class NoteViewModel : ViewModel() {

    private val notesRepository = NotesRepository()

    val notes: Flow<List<Note>> = notesRepository.notes
}