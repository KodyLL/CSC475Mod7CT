package com.kluke.csc475mod7ct

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val conversionFormulas : ConversionFormulas = ConversionFormulas()
        val units = listOf("Fahrenheit", "Celsius", "Kelvin")
        var fromUnit : String = ""
        var toUnit: String = ""
        var fromValue: Double = 0.0
        //var resultValue: Double = 0.0
        val resultValueField : TextView = findViewById(R.id.resultField)
        val resultUnitLabel : TextView = findViewById(R.id.resultsUnit)
        val fromValueField : TextView = findViewById(R.id.fromValue)
        val calcButton: Button = findViewById(R.id.calcButton)
        val toUnitSpinner: Spinner = findViewById(R.id.toUnitsSpinner)
        val fromUnitSpinner: Spinner = findViewById(R.id.fromUnitsSpinner)
        val toUnitAdapter = ArrayAdapter(this, R.layout.spinner_item, units)
        val fromUnitAdapter = ArrayAdapter(this, R.layout.spinner_item,units)
        toUnitSpinner.adapter = toUnitAdapter
        fromUnitSpinner.adapter = fromUnitAdapter
        toUnitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, i: Int, l: Long) {

                val selected = parent.getItemAtPosition(i)
                toUnit = selected.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        fromUnitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, i: Int, l: Long) {

                val selected = parent.getItemAtPosition(i)
                fromUnit = selected.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        calcButton.setOnClickListener() {
            var result :Double = 0.0
            if (fromValueField.text.isNotEmpty()) {
                fromValue = fromValueField.text.toString().toDouble()
                Log.d("String", fromValueField.text.toString().toDouble().toString())
                if (fromUnit == toUnit){
                    result = fromValue
                }
                if ((fromUnit == "Fahrenheit") && (toUnit == "Celsius")) {
                    result = conversionFormulas.FtoC(fromValue)
                }
                if ((fromUnit == "Celsius") && (toUnit == "Fahrenheit")) {
                    result = conversionFormulas.CtoF(fromValue)
                }
                if ((fromUnit == "Fahrenheit") && (toUnit == "Kelvin")) {
                    result = conversionFormulas.FtoK(fromValue)
                }
                if ((fromUnit == "Kelvin") && (toUnit == "Fahrenheit")) {
                    result = conversionFormulas.KtoF(fromValue)
                }
                if ((fromUnit == "Celsius") && (toUnit == "Kelvin")) {
                    result = conversionFormulas.CtoK(fromValue)
                }
                if ((fromUnit == "Kelvin") && (toUnit == "Celsius")) {
                    result = conversionFormulas.KtoC(fromValue)
                }
                resultUnitLabel.text = toUnit
                resultValueField.text = result.toString()
            }
            else{
                Toast.makeText(this, "No Value Entered",Toast.LENGTH_SHORT).show()
                resultUnitLabel.text = ""
                resultValueField.text = ""
            }
        }
    }
}