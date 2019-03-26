package ru.mail.park.android.zinovyev.task02.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.mail.park.android.zinovyev.task02.R
import kotlin.random.Random
import kotlin.random.nextUInt


@ExperimentalUnsignedTypes
class MainActivity : AppCompatActivity() {

    private lateinit var mTextView: TextView
    private lateinit var mNumberField: EditText
    private lateinit var mButton: Button

    private var mNumber: UInt = 0u
    private val mRandom = Random(0)

    private var mGameOver: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.text)
        mNumberField = findViewById(R.id.number)
        mButton = findViewById(R.id.button)

        mButton.setOnClickListener { onButtonClick() }

        startNewGame()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.new_game -> {
                startNewGame()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onButtonClick() {
        if (mGameOver) {
            return
        }

        try {
            val n = mNumberField.text.toString().toUInt()
            if (n == mNumber) {
                mGameOver = true
                showMessage(resources.getString(R.string.correct_number_message))
            } else {
                showMessage(resources.getString(R.string.wrong_number_message))
            }
        } catch (exception: NumberFormatException) {
            showMessage(resources.getString(R.string.no_number_message))
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun startNewGame() {
        mNumber = mRandom.nextUInt() % 10u
        mGameOver = false

        Log.d(this.javaClass.simpleName, "Random number: $mNumber")
    }
}
