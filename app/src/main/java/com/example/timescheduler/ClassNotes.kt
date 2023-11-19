package com.example.timescheduler
import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timescheduler.databinding.ActivityClassNotesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint


class ClassNotes: AppCompatActivity() {

    private lateinit var binding:ActivityClassNotesBinding
    private lateinit var db:NoteDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityClassNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= NoteDatabaseHelper(this)
        notesAdapter= NotesAdapter(db.getallNotes(),this)
        binding.notesRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.notesRecyclerView.adapter=notesAdapter
        binding.addButton.setOnClickListener {
            val intent = Intent(this,AddNotes::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshData(db.getallNotes())
    }


}
