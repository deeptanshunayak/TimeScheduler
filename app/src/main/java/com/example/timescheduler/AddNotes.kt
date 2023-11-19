package com.example.timescheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.timescheduler.databinding.ActivityAddNotesBinding

class AddNotes : AppCompatActivity() {
    private lateinit var binding:ActivityAddNotesBinding
    private lateinit var db:NoteDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDatabaseHelper(this)
        binding.save.setOnClickListener {
            val title = binding.editText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Noter(0,title,content)
            db.insert(note)
            finish()
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()
        }

        }

    }
