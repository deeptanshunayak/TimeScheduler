package com.example.timescheduler

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ClassNotes : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var noteList: ListView

    private val notes = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.addButton)
        noteList = findViewById(R.id.noteList)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        noteList.adapter = adapter

        addButton.setOnClickListener {
            val noteText = editText.text.toString()
            if (noteText.isNotEmpty()) {
                notes.add(noteText)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }
    }
}