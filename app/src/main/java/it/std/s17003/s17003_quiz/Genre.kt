package it.std.s17003.s17003_quiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_genre.*

class Genre : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)

        button.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button9.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button11.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }
        button12.setOnClickListener {
            val intent = Intent(this, degree::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Genre"
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
