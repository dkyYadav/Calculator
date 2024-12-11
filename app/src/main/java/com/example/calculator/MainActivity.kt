package com.example.calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // insert operators and numbers
        binding.btnAc.setOnClickListener{
           binding.output.text=""
          binding.preOutput.text=""
        }
       binding.btn0.setOnClickListener{
          binding.preOutput.append("0")
       }


       binding.btn1.setOnClickListener{
           binding.preOutput.append("1")
        }

        binding.btn2.setOnClickListener{
            binding.preOutput.append("2")
        }
        binding.btn3.setOnClickListener{
            binding.preOutput.append("3")
        }

       binding.btn4.setOnClickListener{
            binding.preOutput.append("4")
        }

        binding.btn5.setOnClickListener{
            binding.preOutput.append("5")
        }


        binding.btn6.setOnClickListener{
            binding.preOutput.append("6")
        }

        binding.btn7.setOnClickListener{
            binding.preOutput.append("7")
        }

        binding.btn8.setOnClickListener{
            binding.preOutput.append("8")
        }

      binding.btn9.setOnClickListener{
           binding.preOutput.append("9")
        }


        // operators insert
        binding.btnDot.setOnClickListener{
            binding.preOutput.append(".")
        }

        binding.btnAdd.setOnClickListener{
            binding.preOutput.append("+")
        }

        binding.btnSub.setOnClickListener{
            binding.preOutput.append("-")
        }

        binding.btnMul.setOnClickListener{
            binding.preOutput.append("*")
        }

        binding.btnDivide.setOnClickListener{
            binding.preOutput.append("/")
        }

        binding.btnStartBry.setOnClickListener{
            binding.preOutput.append("(")
        }

        binding.btnEndBry.setOnClickListener{
            binding.preOutput.append(")")
        }


        binding.btnEqual.setOnClickListener{

//              import input in expression to calculate
            val expression = ExpressionBuilder(binding.preOutput.text.toString()).build()
            val result = expression.evaluate()
            val longresult = result.toLong()

            if (result == longresult.toDouble()){
//                  output mach same than
                binding.output.text = longresult.toString()

            }else{
                binding.output.text.toString()
            }


//            dependencies {
//                implementation("net.objecthunter:exp4j:0.4.8")
//            }

        }
    }
}