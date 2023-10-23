package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.ArithmeticException
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var operation:Char?=null
    var value1 = 0.0
    var value2=0.0
    var finalResult=0.0

    var textBuilder=StringBuilder()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDot.setOnClickListener {
            onNumberClicked(binding.btnDot)
        }
        binding.btn0.setOnClickListener {
            onNumberClicked(binding.btn0)
        }
        binding.btn1.setOnClickListener {
            onNumberClicked(binding.btn1)
        }
        binding.btn2.setOnClickListener {
            onNumberClicked(binding.btn2)
        }
        binding.btn3.setOnClickListener {
            onNumberClicked(binding.btn3)
        }
        binding.btn4.setOnClickListener {
            onNumberClicked(binding.btn4)
        }
        binding.btn5.setOnClickListener {
            onNumberClicked(binding.btn5)
        }
        binding.btn6.setOnClickListener {
            onNumberClicked(binding.btn6)
        }
        binding.btn7.setOnClickListener {
            onNumberClicked(binding.btn7)
        }
        binding.btn8.setOnClickListener {
            onNumberClicked(binding.btn8)
        }
        binding.btn9.setOnClickListener {
            onNumberClicked(binding.btn9)
        }
        binding.btnC.setOnClickListener {
            onNumberClicked(binding.btnC)
        }
        binding.btnDel.setOnClickListener {
            onNumberClicked(binding.btnDel)
        }
        binding.btnPlus.setOnClickListener {
            onMathOperationClicked(binding.btnPlus)
        }
        binding.btnMinus.setOnClickListener {
            onMathOperationClicked(binding.btnMinus)
        }
        binding.btnMultiply.setOnClickListener {
            onMathOperationClicked(binding.btnMultiply)
        }
        binding.btnDiv.setOnClickListener {
            onMathOperationClicked(binding.btnDiv)
        }
        binding.btnEqual.setOnClickListener {
           onEqualClicked(binding.btnEqual)
        }
    }

    private fun onNumberClicked(view: View) {
        var valueBuilder = StringBuilder(binding.etResult.text.toString())
        when (view.id) {
            R.id.btn_dot->{
                if(valueBuilder.indexOf(".")==-1){
                    if(valueBuilder.isNotEmpty()){
                        valueBuilder.append(".")
                    }
                    if(textBuilder.isNotEmpty()){
                        textBuilder.append(".")
                    }
                }
            }
            R.id.btn0 -> {
                valueBuilder.append("0")
                textBuilder.append("0")
            }

            R.id.btn1 -> {
                valueBuilder.append("1")
                textBuilder.append("1")
            }

            R.id.btn2 -> {
                valueBuilder.append("2")
                textBuilder.append("2")
            }

            R.id.btn3 -> {
                valueBuilder.append("3")
                textBuilder.append("3")
            }

            R.id.btn4 -> {
                valueBuilder.append("4")
                textBuilder.append("4")
            }

            R.id.btn5 -> {
                valueBuilder.append("5")
                textBuilder.append("5")
            }

            R.id.btn6 -> {
                valueBuilder.append("6")
                textBuilder.append("6")
            }

            R.id.btn7 -> {
                valueBuilder.append("7")
                textBuilder.append("7")
            }

            R.id.btn8 -> {
                valueBuilder.append("8")
                textBuilder.append("8")
            }

            R.id.btn9 -> {
                valueBuilder.append("9")
                textBuilder.append("9")
            }

            R.id.btn_c -> {
                valueBuilder.setLength(0)
                textBuilder.setLength(0)
            }

            R.id.btn_del -> {
                if (valueBuilder.isNotEmpty()) {
                    valueBuilder.deleteCharAt(valueBuilder.length - 1)
                }
                if (textBuilder.length!! > 0) {
                    textBuilder.deleteCharAt(textBuilder.length - 1)
                }
                if(textBuilder.indexOf("=")!=-1){
                    valueBuilder.setLength(0)
                    textBuilder.setLength(0)
                }
            }
        }
        binding.etResult.setText(valueBuilder.toString(), TextView.BufferType.EDITABLE)
        binding.txtResult.setText(textBuilder.toString(), TextView.BufferType.EDITABLE)
    }

    private fun onMathOperationClicked(view: View) {
        when (view.id) {
            R.id.btn_plus -> {
                operation = '+'
            }

            R.id.btn_minus -> {
                operation = '-'
            }

            R.id.btn_multiply -> {
                operation = '*'
            }

            R.id.btn_div -> {
                operation = '/'
            }

        }
        if(binding.etResult.text.isNotEmpty()){
            var value=binding.etResult.text.toString()
            value1=value.toDouble()
            textBuilder.append("$operation")
            binding.txtResult.text=textBuilder.toString()
            binding.etResult.setText("")

        }
    }

    private fun onEqualClicked(view: View){
        if(binding.etResult.text.isNotEmpty()){
            var value=binding.etResult.text.toString()
            value2=value.toDouble()

        }
        when(operation){
            '+'->{
                finalResult=value1+value2
            }
            '-'->{
                finalResult=value1-value2
            }
            '*'->{
                finalResult=value1*value2
            }
            '/'->{
                try {
                  finalResult=value1/value2
                }
                catch (e:ArithmeticException){
                    finalResult=0.0
                }

            }
        }
        textBuilder.append("="+finalResult)
        binding.etResult.setText("$finalResult", TextView.BufferType.EDITABLE)
        binding.txtResult.text=textBuilder.toString()

    }
}