package com.michael.quizapp.utils

import com.michael.quizapp.R
import com.michael.quizapp.model.Question

object Constants {

    fun getQuestions(): MutableList<Question> {
        val question = mutableListOf<Question>()

        val question1 = Question(
            1, "What country does this flag belong?",
            R.drawable.argentina_flag, "Argentina", "India", "Nigeria", "Spain", 1
        )
        question.add(question1)

        val question2 = Question(
            2, "What country does this flag belong?",
            R.drawable.brazil_flag, "France", "Spain", "Brazil", "Itally", 3
        )
        question.add(question2)

        val question3 = Question(
            3, "What country does this flag belong?",
            R.drawable.finland_flag, "Germany", "Finland", "Haiti", "France", 2
        )
        question.add(question3)

        val question4 = Question(
            3, "What country does this flag belong?",
            R.drawable.germany_flag, "Spain", "India", "London", "Germany", 4
        )
        question.add(question4)

        val question5 = Question(
            3, "What country does this flag belong?",
            R.drawable.haiti_flag, "Brazil", "Haiti", "Finland", "Italy", 2
        )
        question.add(question5)

        val question6 = Question(
            3, "What country does this flag belong?",
            R.drawable.india_flag, "Ireland", "India", "Nigeria", "London", 2
        )
        question.add(question6)

        val question7 = Question(
            3, "What country does this flag belong?",
            R.drawable.italy_flag, "Italy", "Ghana", "Romania", "Argentina", 1
        )
        question.add(question7)

        val question8 = Question(
            3, "What country does this flag belong?",
            R.drawable.nigeria_flag, "Haiti", "Polish", "Kenya", "Nigeria", 4
        )
        question.add(question8)

        val question9 = Question(
            3, "What country does this flag belong?",
            R.drawable.romania_flag, "Finland", "Romania", "France", "Germany", 2
        )
        question.add(question9)

        val question10 = Question(
            3, "What country does this flag belong?",
            R.drawable.spain_flag, "France", "Argentina", "Spain", "Mexico", 3
        )
        question.add(question10)

        return question
    }
}