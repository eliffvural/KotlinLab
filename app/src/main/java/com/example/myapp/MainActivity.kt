package com.example.myapp

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textView.text="HELLO KOTLIN!!!"

       /*
        binding.button.setOnClickListener{
            binding.textView.text="clicked to button"
        }
        */

        /*
    val image= findViewById<ImageView>(R.id.imageView)
        val text= findViewById<TextView>(R.id.textView)
        text.text="hello kotlin!!"
        */



    }

     fun button(view: View){
         binding.textView.text="saved"
     }

    fun button2(view: View){
        binding.textView.text="not saved"

    }



}