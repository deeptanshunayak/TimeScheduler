package com.example.timescheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNotes : AppCompatActivity() {
    private lateinit var noteEditText: EditText
    private lateinit var addnoteButton: Button
    private lateinit var noteDo: NoteDo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
        noteEditText = findViewById(R.id.notesEditText)
        addnoteButton=findViewById(R.id.notesbutton)
        noteDo=NoteDo()
        addnoteButton.setOnClickListener {
            val note = noteEditText.text.toString()
            if(note.isNotEmpty()){
                noteDo.addnote(note)
                val intent = Intent(this,ClassNotes::class.java)
                startActivity(intent)
            }
        }

    }
}