package com.example.timescheduler
import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ClassNotes: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_notes)
        recyclerView=findViewById(R.id.recyclerView)
        fab=findViewById(R.id.fab)
        fab.setOnClickListener {
         val intent=Intent(this,AddNotes::class.java)

            startActivity(intent)
        }


    }



}
