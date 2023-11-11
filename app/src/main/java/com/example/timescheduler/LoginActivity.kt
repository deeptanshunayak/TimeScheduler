package com.example.timescheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.timescheduler.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    var email1: EditText?=null
    var password:EditText?=null
    private lateinit var binding:ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        email1=findViewById(R.id.et_email)
        password=findViewById(R.id.et_password)
        firebaseAuth= FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            val em=binding.etEmail.text.toString()
            val ps=binding.etPassword.text.toString()

            if(email1!!.length()==0){

                Toast.makeText(this,"EMAIL IS REQUIRED", Toast.LENGTH_SHORT).show()
            }
            else if(password!!.length()==0){
                Toast.makeText(this,"PASSWORD IS REQUIRED",Toast.LENGTH_SHORT).show()
            }
            else{
                firebaseAuth.signInWithEmailAndPassword(em, ps).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this,HomePage::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        binding.HaveAcoount.setOnClickListener{
            startActivity(Intent(this,Register_Activity::class.java))
        }
    }
}