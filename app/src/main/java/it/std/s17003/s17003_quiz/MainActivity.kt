package it.std.s17003.s17003_quiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        degree.setOnClickListener {
            val intent = Intent(this, Genre::class.java)
            startActivity(intent)

        }
        random.setOnClickListener {
            val intent = Intent(this, RandomQuiz::class.java)
            startActivity(intent)
        }

    }
}
