package com.mrivas.ibm_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.component1
import org.w3c.dom.Text
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var weight_input:EditText
    private lateinit var height_input:EditText
    private lateinit var calculate_button:Button
    private lateinit var showBMI:TextView
    private lateinit var weight_class_txt:TextView
    private lateinit var sub_text:TextView

    private var weight = 0.00
    private var height = 0.00
    private var bmi = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    private fun bind() {
        weight_input = findViewById<EditText>(R.id.weight_input)
        height_input = findViewById<EditText>(R.id.height_input)
        calculate_button = findViewById<Button>(R.id.btn_calculate)
        showBMI = findViewById<TextView>(R.id.show_bmi)
        weight_class_txt = findViewById<TextView>(R.id.txt_weight_class)
        sub_text = findViewById<TextView>(R.id.sub_text)
    }

    private fun addListener() {
        calculate_button.setOnClickListener {
            if(isEmpty(weight_input, height_input)) {
                return@setOnClickListener
            }

            weight = weight_input.text.toString().toDouble()
            height = height_input.text.toString().toDouble()

            bmi = ((weight / (height / 100.00).pow(2) * 100)).roundToInt() / 100.0

            var color = 0

            if (bmi < 18.5) {
                weight_class_txt.text = "Underweight"
                color = R.color.under_weight
            } else if (bmi in 18.5..24.99) {
                weight_class_txt.text = "Healthy"
                color = R.color.healthy
            } else if (bmi in 25.0..29.99) {
                weight_class_txt.text = "Overweight"
                color = R.color.overweight
            } else {
                weight_class_txt.text = "Obese"
                color = R.color.obese
            }
            weight_class_txt.setTextColor(ContextCompat.getColor(this, color))
            sub_text.text = "(Normal range is 18.5 - 24)"
            showBMI.text = bmi.toString()
        }
    }

    private fun isEmpty(weight: EditText, height: EditText) : Boolean {
        if (weight.text.toString().isNullOrEmpty()) {
            Toast.makeText(applicationContext, "Enter a valid weight!", Toast.LENGTH_SHORT).show()
            return true
        } else if (height.text.toString().isNullOrEmpty()) {
            Toast.makeText(applicationContext, "Enter a valid height!", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}