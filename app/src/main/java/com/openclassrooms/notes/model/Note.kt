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
 * Classe permettant de gérer une liste de notes avec des opérations de base.
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
     * Supprime une note de la liste.
     *
     * @param note La note à supprimer.
     * @return `true` si la note a été supprimée, `false` sinon.
     */
    fun removeNote(note: Note): Boolean {
        return notes.remove(note)
    }

    /**
     * Modifie une note existante par une nouvelle.
     *
     * @param oldNote La note à remplacer.
     * @param newNote La nouvelle note.
     * @return `true` si la modification a réussi, `false` si la note d’origine n’a pas été trouvée.
     */
    fun updateNote(oldNote: Note, newNote: Note): Boolean {
        val index = notes.indexOf(oldNote)
        return if (index != -1) {
            notes[index] = newNote
            true
        } else {
            false
        }
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
