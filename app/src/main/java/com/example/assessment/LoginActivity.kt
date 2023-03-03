package com.example.assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var loginEmail: EditText
    private lateinit var loginPw: EditText
    private lateinit var loginBtn: Button
    private lateinit var registerBtn:Button
    private lateinit var logAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginEmail=findViewById(R.id.editTextTextPersonName)
        loginPw=findViewById(R.id.editTextTextPassword)
        loginBtn=findViewById(R.id.button)
        registerBtn=findViewById(R.id.button2)
        logAuth= FirebaseAuth.getInstance()

        registerBtn.setOnClickListener {
            val txt_email = loginEmail.text.toString()
            val txt_pw=loginPw.text.toString()

            if(txt_email.isNullOrEmpty() || txt_pw.isNullOrEmpty()){
                Toast.makeText(this, "Empty credentials", Toast.LENGTH_SHORT).show()
            }else if(txt_pw.length<6){
                Toast.makeText(this,"Minimum length should be 6",Toast.LENGTH_LONG).show()
            }else{
                registerUser()
            }
        }

        loginBtn.setOnClickListener {
            val txt_mail=loginEmail.text.toString()
            val txt_pw=loginPw.text.toString()

            if(txt_mail.isNullOrEmpty() || txt_pw.isNullOrEmpty()){
                Toast.makeText(this, "Empty credentials", Toast.LENGTH_SHORT).show()
            }else{
                LoginUser()

            }
        }
    }

    private fun registerUser() {
        val txt_email = loginEmail.text.toString()
        val txt_pw=loginPw.text.toString()
        logAuth.createUserWithEmailAndPassword(txt_email,txt_pw).addOnCompleteListener{task->
            if(task.isSuccessful){
                val intent= Intent(this,DashboardActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Registered successfully",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun LoginUser() {
        val txt_mail=loginEmail.text.toString()
        val txt_pw=loginPw.text.toString()

        logAuth.signInWithEmailAndPassword(txt_mail,txt_pw).addOnCompleteListener{task->
            if(task.isSuccessful){
                val intent= Intent(this,DashboardActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Logged in Successfully",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}