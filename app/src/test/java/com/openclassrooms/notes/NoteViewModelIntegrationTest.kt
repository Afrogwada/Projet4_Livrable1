package com.openclassrooms.notes.widget

import app.cash.turbine.test
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.LocalNotesApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test



/**
 * Test d'intégration du ViewModel NoteViewModel avec la vraie implémentation NotesRepository
 * qui utilise LocalNotesApiService.
 */
@ExperimentalCoroutinesApi
class NoteViewModelIntegrationTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: NoteViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        // Création du service local
        val apiService = LocalNotesApiService()

        // Création du repository avec le service local
        val repository = NotesRepository(apiService)

        // Injection du repository dans le ViewModel
        viewModel = NoteViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    /**
     * Vérifie que le ViewModel expose bien la liste des notes initialisée par LocalNotesApiService.
     */
    @Test
    fun `notes flow emits notes from repository`() = runTest {
        viewModel.notes.test {

            // Comme dans loadNotes() la collecte est lancée dans une coroutine,
            // on avance la coroutine pour que la valeur réelle soit émise
            testDispatcher.scheduler.advanceUntilIdle()

            // Ensuite, on obtient la liste des notes du service local via le repository
            val emittedNotes = awaitItem()

            // Vérifie que la liste émise correspond bien à celle du service local
            val expectedNotes = LocalNotesApiService().getAllNotes()
            assertEquals(expectedNotes, emittedNotes)

            cancelAndIgnoreRemainingEvents()
        }
    }
}
