package com.example.timescheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.timescheduler.databinding.ActivityLoginBinding
import com.example.timescheduler.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register_Activity : AppCompatActivity() {
   var bproceed:Button?=null
    var name:EditText?=null
    var email1:EditText?=null
    var uname:EditText?=null
    var password:EditText?=null
    var roll:EditText?=null
    var ischecked=false;
    private lateinit var binding:ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bproceed=findViewById(R.id.btn_register)
        name=findViewById(R.id.et_fullname)
        email1=findViewById(R.id.et_email)
        uname=findViewById(R.id.et_username)
        password=findViewById(R.id.et_password)
        firebaseAuth= FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            val em=binding.etEmail.text.toString()
            val ps=binding.etPassword.text.toString()

           if(name!!.length()==0){

               Toast.makeText(this,"NAME IS REQUIRED",Toast.LENGTH_SHORT).show()
           }
            else if(email1!!.length()==0){
               Toast.makeText(this,"EMAIL IS REQUIRED",Toast.LENGTH_SHORT).show()
           }
           else if(uname!!.length()==0){
               Toast.makeText(this,"USERNAME IS REQUIRED",Toast.LENGTH_SHORT).show()
           }
           else if(password!!.length()==0){
               Toast.makeText(this,"PASSWORD IS REQUIRED",Toast.LENGTH_SHORT).show()
           }

            else{
               firebaseAuth.createUserWithEmailAndPassword(em, ps).addOnCompleteListener {
                   if(it.isSuccessful){
                       val intent = Intent(this,LoginActivity::class.java)
                       startActivity(intent)
                   }
                   else{
                       Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                   }
               }

           }

        }

        binding.HavenAcoount.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
    private fun checkAllFields(): Boolean {
        if (name!!.length() == 0) {
            name!!.error = "This field is required"
            return false
        }
        if(uname!!.length()==0){
            uname!!.error="This field is required"
            return false
        }
        if (email1!!.length() == 0) {
            email1!!.error = "Email is required"

            return false}
            else if(email1!!.length()<10){
                email1!!.error="email length is too short"
                return false
            }

        if (password!!.length() == 0) {
            password!!.error = "Password is required"
            return false
        } else if (password!!.length() < 8) {
            password!!.error = "Password must be minimum 8 characters"
            return false
        }
        if(roll!!.length()==0){
            roll!!.error="Please Enter Your Roll Number"
        }

        // after all validation return true.
        return true
    }

}

