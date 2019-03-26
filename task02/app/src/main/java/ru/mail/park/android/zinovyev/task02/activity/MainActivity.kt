package ru.mail.park.android.zinovyev.task02.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
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

        initNumber()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    private fun onButtonClick() {
        if (mGameOver) {
            return
        }

        try {
            val n = mNumberField.text.toString().toUInt()
            if (n == mNumber) {
                mGameOver = true
                showMessage("Congratulations! You won!")
            } else {
                showMessage("Try one more time!")
            }
        } catch (exception: NumberFormatException) {
            showMessage("Number expected!")
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun initNumber() {
        mNumber = mRandom.nextUInt() % 10u
        Log.d(this.javaClass.simpleName, "Random number: $mNumber")
    }
}
