package com.example.timescheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timescheduler.databinding.ActivityRegisterBinding

class Register_Activity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnRegister.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))

        }
        binding.HavenAcoount.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}