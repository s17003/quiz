package it.std.s17003.s17003_quiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_degree.*


class degree : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_degree)

        easy.setOnClickListener {
            val intent = Intent(this, EasyQuiz::class.java)
            startActivity(intent)

        }
        difficult.setOnClickListener {
            val intent = Intent(this, DifficultQuiz::class.java)
            startActivity(intent)

        }
    }
}
