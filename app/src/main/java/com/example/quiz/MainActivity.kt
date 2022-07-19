package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initializer)

        val btnStart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)

        etName.setOnClickListener{
            etName.background = null
        }

        btnStart.setOnClickListener {
           if(etName.text.isEmpty()) {
               Toast.makeText(this, "Enter your name", Toast.LENGTH_LONG).show()
           } else if(etName.text.count() < 3){
               Toast.makeText(this, "Enter a valid name with 3 or more characters", Toast.LENGTH_LONG).show()
           } else {
               val intent = Intent(this, QuizQuestionsActivity::class.java)
               intent.putExtra(Constants.USER_NAME, etName.text.toString())
               startActivity(intent)
               finish()
           }
        }
    }
}