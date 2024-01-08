package com.michael.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michael.quizapp.MainActivity
import com.michael.quizapp.R
import com.michael.quizapp.databinding.ActivityResultBinding
import com.michael.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        binding.nameTextView.text = name
        binding.scoreTextView.text = "Your score is $score out of $totalQuestions"

        binding.finishButton.setOnClickListener{
            Intent(this@ResultActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}