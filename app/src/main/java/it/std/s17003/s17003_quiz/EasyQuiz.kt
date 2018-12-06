package it.std.s17003.s17003_quiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem


class EasyQuiz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_quiz)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "EasyQuiz"
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}


