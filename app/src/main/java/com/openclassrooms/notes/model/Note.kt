package com.openclassrooms.notes.model
/**
 * Classe de données représentant une note composée d’un titre et d’un corps.
 *
 * @property title Le titre de la note.
 * @property body Le contenu ou corps de la note.
 */
data class Note(
    val title: String,
    val body: String
)

/**
 * Classe permettant de gérer une liste de notes.
 */
class NoteManager {

    private val notes = mutableListOf<Note>()

    /**
     * Ajoute une nouvelle note à la liste.
     *
     * @param note La note à ajouter.
     */
    fun addNote(note: Note) {
        notes.add(note)
    }

    /**
     * Récupère toutes les notes enregistrées.
     *
     * @return La liste des notes.
     */
    fun getAllNotes(): List<Note> = notes.toList()

    /**
     * Recherche les notes contenant un mot-clé dans le titre.
     *
     * @param keyword Le mot-clé à rechercher.
     * @return La liste des notes correspondantes.
     */
    fun searchNotesByTitle(keyword: String): List<Note> {
        return notes.filter { it.title.contains(keyword, ignoreCase = true) }
    }
}
