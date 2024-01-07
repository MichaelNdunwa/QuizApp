package com.michael.quizapp.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.michael.quizapp.R
import com.michael.quizapp.databinding.ActivityQuestionsBinding
import com.michael.quizapp.model.Question
import com.michael.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionsBinding
    private var questionsCounter = 0
    private lateinit var questionsList: MutableList<Question>
    private var selectedOptionPosition = 0
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false

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
        showNextQuestion()
    }

    //    private fun showNextQuestion() {
    private fun showNextQuestion() {
        resetOptions()
        val question = questionsList[questionsCounter]
        binding.flagImage.setImageResource(question.image)
        binding.progressBar.progress = questionsCounter
        binding.textViewProgress.text = "${questionsCounter + 1}/${binding.progressBar.max}"
        binding.textViewOptionOne.text = question.optionOne
        binding.textViewOptionTwo.text = question.optionTwo
        binding.textViewOptionThree.text = question.optionThree
        binding.textViewOptionFour.text = question.optionFour

        // Change progress bar color:
        binding.progressBar.progressDrawable.setTintList(ColorStateList.valueOf(Color.BLACK))


        /*   if (questionsCounter < questionsList.size) {
               binding.checkButton.text = "CHECK"
               currentQuestion = questionsList[questionsCounter]
           } else {
               binding.checkButton.text = "FINISH"
           }*/

        when {
            questionsCounter < questionsList.size -> {
                binding.checkButton.text = "CHECK"
                currentQuestion = questionsList[questionsCounter]
            }

            else -> {
                binding.checkButton.text = "FINISH"
            }
        }

        questionsCounter++
        answered = false

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

    override fun onClick(view: View?) {
        when (view?.id) {
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
                if (!answered) {
                    checkAnswer()
                } else {
                    //showNextQuestion()
                    showNextQuestion()
                }

                /*if (answered) {
                   // showNextQuestion()
                    setQuestion()
                } else {
                    checkAnswer()
                }*/

                selectedAnswer = 0
            }

        }
    }


    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()
//        selectedOptionPosition = selectedOptionNumber
        selectedAnswer = selectedOptionNumber // my correction to the code.
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    private fun checkAnswer() {
        answered = true

        if (selectedAnswer == currentQuestion.correctAnswer) {
            highlightCorrectAnswer(selectedAnswer)
        } else {
            highlightWrongAnswer(selectedAnswer)
        }

        binding.checkButton.text = "NEXT"
        showSolution()
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer
        highlightCorrectAnswer(selectedAnswer)
    }

    private fun highlightCorrectAnswer(answer: Int) {
        when (answer) {
            1 -> {
                binding.textViewOptionOne.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_border_bg
                )
            }

            2 -> {
                binding.textViewOptionTwo.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_border_bg
                )
            }

            3 -> {
                binding.textViewOptionThree.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_border_bg
                )
            }

            4 -> {
                binding.textViewOptionFour.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_border_bg
                )
            }
        }
    }

    private fun highlightWrongAnswer(answer: Int) {
        when (selectedAnswer) {
            1 -> {
                binding.textViewOptionOne.background = ContextCompat.getDrawable(
                    this, R.drawable.wrong_option_border_bg
                )
            }

            2 -> {
                binding.textViewOptionTwo.background = ContextCompat.getDrawable(
                    this, R.drawable.wrong_option_border_bg
                )
            }

            3 -> {
                binding.textViewOptionThree.background = ContextCompat.getDrawable(
                    this, R.drawable.wrong_option_border_bg
                )
            }

            4 -> {
                binding.textViewOptionFour.background = ContextCompat.getDrawable(
                    this, R.drawable.wrong_option_border_bg
                )
            }
        }
    }
}