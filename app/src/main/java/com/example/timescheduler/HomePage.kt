package com.example.timescheduler


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timescheduler.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addNotes.setOnClickListener {
            startActivity(Intent(this,ClassNotes::class.java))
        }
        binding.viewtimetable.setOnClickListener {
            startActivity(Intent(this,SectionActivity::class.java))
        }
        binding.setReminder.setOnClickListener {
            startActivity(Intent(this,Notification::class.java))
        }
        binding.viewSyllaus.setOnClickListener {
            startActivity(Intent(this,SectionActivity::class.java))
        }
    }
}