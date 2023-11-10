package com.example.timescheduler
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class edit_note : AppCompatActivity() {
    private lateinit var editNoteText: EditText
    private lateinit var saveNoteButton: Button
    private var originalNote: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        editNoteText = findViewById(R.id.editNoteText)
        saveNoteButton = findViewById(R.id.saveNoteButton)

        originalNote = intent.getStringExtra("note")
        editNoteText.setText(originalNote)

        saveNoteButton.setOnClickListener {
            val editedNote = editNoteText.text.toString()
            if (originalNote != null) {
                NoteManager.deleteNote(this, originalNote!!)
            }
            if (editedNote.isNotEmpty()) {
                NoteManager.saveNote(this, editedNote)
            }
            finish()
        }
    }
}
