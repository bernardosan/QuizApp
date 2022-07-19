package com.example.quiz

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var isOptionSelected: Boolean = false
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestions : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOption1 : TextView? = null
    private var tvOption2 : TextView? = null
    private var tvOption3 : TextView? = null
    private var tvOption4 : TextView? = null
    private var tvOption5 : TextView? = null
    private var buttonSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.progressbar_txt)
        tvQuestions = findViewById(R.id.question_text)
        ivImage = findViewById(R.id.question_image)
        tvOption1 = findViewById(R.id.opt1)
        tvOption2 = findViewById(R.id.opt2)
        tvOption3 = findViewById(R.id.opt3)
        tvOption4 = findViewById(R.id.opt4)
        tvOption5 = findViewById(R.id.opt5)
        buttonSubmit = findViewById(R.id.btn_submit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        tvOption5?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)


        mQuestionsList = Constants.getQuestion()

        setQuestion()



    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestions?.text = question.questions
        ivImage?.setImageResource(question.image)
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour
        tvOption5?.text = question.optionFive

        if (mCurrentPosition == mQuestionsList!!.size){
            buttonSubmit?.text = "FINISH"
        } else {
            buttonSubmit?.text = "SUBMIT"
        }

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0,it)
        }
        tvOption2?.let {
            options.add(1,it)
        }
        tvOption3?.let {
            options.add(2,it)
        }
        tvOption4?.let {
            options.add(3,it)
        }
        tvOption5?.let {
            options.add(4,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int ){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.opt1 -> {
                when {
                    isOptionSelected == false ->{
                        tvOption1?.let {
                            selectedOptionView(it,1)
                        }
                    }
                }
            }
            R.id.opt2 -> {
                when {
                    isOptionSelected == false ->{
                        tvOption2?.let {
                            selectedOptionView(it,2)
                        }
                    }
                }
            }
            R.id.opt3 -> {
                when {
                    isOptionSelected == false ->{
                        tvOption3?.let {
                            selectedOptionView(it,3)
                        }
                    }
                }
            }
            R.id.opt4 -> {
                when {
                    isOptionSelected == false ->{
                        tvOption4?.let {
                            selectedOptionView(it,4)
                        }
                    }
                }
            }
            R.id.opt5 -> {
                when {
                    isOptionSelected == false ->{
                        tvOption5?.let {
                            selectedOptionView(it,5)
                        }
                    }
                }
            }

            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){

                    if(isOptionSelected == true) {
                        mCurrentPosition++

                        when {
                            mCurrentPosition <= mQuestionsList!!.size -> {
                                setQuestion()
                            } else -> {
                                val intent = Intent(this, ActivityResults::class.java)
                                intent.putExtra(Constants.USER_NAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                        isOptionSelected = false

                    } else {
                        Toast.makeText(this,"Select an option to the next question", Toast.LENGTH_SHORT).show()
                    }
                } else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        buttonSubmit?.text = "FINISH"
                    } else{
                        buttonSubmit?.text = "NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                    isOptionSelected = true

                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int ){
        when(answer){
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(this,drawableView)
            }
            5 -> {
                tvOption5?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

}

