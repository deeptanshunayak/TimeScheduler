package com.example.timescheduler

import android.content.Context

object NoteManager {
    private const val PREF_NAME = "Notes"
    private const val KEY_NOTES = "notes"

    fun getNotes(context: Context): MutableList<String> {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet(KEY_NOTES, HashSet())?.toMutableList() ?: mutableListOf()
    }

    fun saveNote(context: Context, note: String) {
        val notes = getNotes(context)
        notes.add(note)
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putStringSet(KEY_NOTES, HashSet(notes))
            .apply()
    }

    fun updateNotes(context: Context, updatedNotes: List<String>) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putStringSet(KEY_NOTES, HashSet(updatedNotes))
            .apply()
    }

    fun deleteNote(context: Context, note: String) {
        val notes = getNotes(context)
        notes.remove(note)
        updateNotes(context, notes)
    }
}
