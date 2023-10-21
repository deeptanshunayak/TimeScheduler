package com.example.timescheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import com.example.timescheduler.databinding.ActivityMainBinding
import com.example.timescheduler.databinding.ActivitySectionBinding

class SectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        findViewById<RadioButton>(R.id.radio_button_1).setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnTimetable.setOnClickListener{
                startActivity(Intent(this,TimeTable::class.java))
            }
        }
        findViewById<RadioButton>(R.id.radio_button_2).setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnTimetable.setOnClickListener{
                startActivity(Intent(this,TimeTable1::class.java))
            }
        }
        findViewById<RadioButton>(R.id.radio_button_3).setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnTimetable.setOnClickListener{
                startActivity(Intent(this,TimeTable2::class.java))
            }
        }
    }

}