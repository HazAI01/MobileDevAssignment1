package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val num: EditText = findViewById(R.id.num)
        val result: TextView = findViewById(R.id.result)

        var flag: String = "even"
        val spinnerVal: Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("even", "odd")
        spinnerVal.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        button.setOnClickListener{ view->
            var x: Int = num.text.toString().toInt();

            if(flag=="even")
                result.text = even(x).toString();
            else
                result.text = odd(x).toString();
        }
    }
}

public fun even(num: Int): Boolean {
    return num%2==0
}

public fun odd(num: Int): Boolean {
    return num%2!=0
}