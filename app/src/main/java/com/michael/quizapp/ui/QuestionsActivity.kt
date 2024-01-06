package com.michael.quizapp.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.michael.quizapp.R
import com.michael.quizapp.databinding.ActivityQuestionsBinding
import com.michael.quizapp.model.Question
import com.michael.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionsBinding
    private val currentPosition = 1
    private lateinit var questionsList: MutableList<Question>
    private var selectedOptionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewOptionOne.setOnClickListener(this)
        binding.textViewOptionTwo.setOnClickListener(this)
        binding.textViewOptionThree.setOnClickListener(this)
        binding.textViewOptionFour.setOnClickListener(this)
        binding.checkButton.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        val question = questionsList[currentPosition]
        binding.flagImage.setImageResource(question.image)
        binding.progressBar.progress = currentPosition
        binding.textViewProgress.text = "$currentPosition/${binding.progressBar.max}"
        binding.textViewOptionOne.text = question.optionOne
        binding.textViewOptionTwo.text = question.optionTwo
        binding.textViewOptionThree.text = question.optionThree
        binding.textViewOptionFour.text = question.optionFour

        when(currentPosition) {
            questionsList.size -> binding.checkButton.text = "FINISH"
            else -> binding.checkButton.text = "CHECK"
        }

    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(binding.textViewOptionOne)
        options.add(binding.textViewOptionTwo)
        options.add(binding.textViewOptionThree)
        options.add(binding.textViewOptionFour)

        options.forEach { option ->
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()

        selectedOptionPosition = selectedOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }



    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.text_view_option_one -> {
                selectedOption(binding.textViewOptionOne, 1)
            }
            R.id.text_view_option_two -> {
                selectedOption(binding.textViewOptionTwo, 2)
            }
            R.id.text_view_option_three -> {
                selectedOption(binding.textViewOptionThree, 3)
            }
            R.id.text_view_option_four -> {
                selectedOption(binding.textViewOptionFour, 4)
            }
            R.id.check_button -> {

            }
        }
    }
}