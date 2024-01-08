package com.michael.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.michael.quizapp.databinding.ActivityMainBinding
import com.michael.quizapp.ui.QuestionsActivity
import com.michael.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            if (binding.name.text!!.isNotEmpty() && binding.email.text!!.isNotEmpty()) {
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, binding.name.text.toString())
                    startActivity(it)
                    finish()
                }
            } else {
                Snackbar.make(
                    binding.startButton,
                    "Fill in your details first.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        }

    }
}