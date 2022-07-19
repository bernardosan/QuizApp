package com.example.quiz

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answer"

    fun getQuestion(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Brazil",
            "Argentina",
            "United States of America",
            "Uruguay",
            "Bolivia",
            2,
        )

        questionsList.add(q1)

        val q2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Finland",
            "Norway",
            "Germany",
            "Denmark",
            "Poland",
            4,
        )

        questionsList.add(q2)

        val q3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Australia",
            "New Zealand",
            "Canada",
            "Greece",
            "Luxembourg",
            1,
        )

        questionsList.add(q3)

        val q4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Hawaii",
            "Marrocos",
            "Jamaica",
            "Equador",
            "Fiji",
            5,
        )

        questionsList.add(q4)


        val q5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Russia",
            "Ukraine",
            "Kuwait",
            "Fiji",
            "India",
            5,
        )

        questionsList.add(q5)

        val q6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Belgium",
            "Singapure",
            "New Zealand",
            "Australia",
            "Belarus",
            3,
        )

        questionsList.add(q6)

        val q7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bulgaria",
            "Egypt",
            "Haiti",
            "Belgium",
            "Austria",
            4,
        )

        questionsList.add(q7)

        val q8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Iraq",
            "Lithuania",
            "Germany",
            "Belgium",
            "Netherlands",
            3,
        )

        questionsList.add(q8)

        val q9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Romania",
            "Kuwait",
            "Serbia",
            "South Africa",
            "Thailand",
            2,
        )

        questionsList.add(q9)

        val q10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Venezuela",
            "Portugal",
            "Colombia",
            "Chile",
            1,
        )

        questionsList.add(q10)

        return questionsList

    }

}