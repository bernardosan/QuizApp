package com.example.quiz


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val tvName : TextView = findViewById(R.id.tvUsername)
        val tvScore : TextView = findViewById(R.id.tvResults)
        val buttonFinish : Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}