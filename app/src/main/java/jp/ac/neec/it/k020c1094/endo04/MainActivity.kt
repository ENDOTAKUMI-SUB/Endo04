package jp.ac.neec.it.k020c1094.endo04

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btClick = findViewById<Button>(R.id.btClick)
        var btClear = findViewById<Button>(R.id.btClear)

        val listener = HelloListener()
        btClick.setOnClickListener(listener)
        btClear.setOnClickListener(listener)

    }

    private inner class HelloListener : View.OnClickListener {
        override fun onClick(view: View) {
            var input001 = findViewById<EditText>(R.id.etName001)
            var input002 = findViewById<EditText>(R.id.etName002)

            val output = findViewById<TextView>(R.id.tvOutput)

            when (view.id) {
                R.id.btClick -> {
                    val inputStr001 = input001.text.toString()
                    val inputStr002 = input002.text.toString()

                    if (inputStr001 != "" && inputStr002 == "") {
                        output.text = getString(R.string.tv_msg_001, inputStr001)

                    } else if (inputStr001 == "" && inputStr002 != "") {
                        output.text = getString(R.string.tv_msg_002, inputStr002)


                    } else if (inputStr001 != "" && inputStr002 != "") {
                        output.text = getString(R.string.tv_msg_003, inputStr001, inputStr002)

                    } else {
                        output.text = ""

                    }
                }
                R.id.btClear -> {
                    input001.setText("")
                    input002.setText("")

                    output.text = ""
                }
            }
        }
    }
}