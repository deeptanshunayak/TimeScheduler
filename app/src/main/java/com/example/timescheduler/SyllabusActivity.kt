package com.example.timescheduler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timescheduler.databinding.ActivitySyllabusBinding

class SyllabusActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySyllabusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySyllabusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginTitle1.setOnClickListener {
            openUrl("https://drive.google.com/drive/recent")
        }
    }

    private fun openUrl(link:String) {
    val uri = Uri.parse(link)
        val intent=Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }
}