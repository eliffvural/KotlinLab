package com.example.myapp

import android.content.Intent
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

    override fun onStart() {
        super.onStart()
        println("onStart executed!")

    }

    override fun onResume() {
        super.onResume()
        println("onResume executed!")

    }

    override fun onPause() {
        super.onPause()
        println("onPause executed!")

    }

    override fun onStop() {
        super.onStop()
        println("onStop executed!")

    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy executed!")

    }

    fun nextPage(view: View){

        val intent=Intent(this, SecondActivity::class.java)
        startActivity(intent)
        //val userLogin= binding.editText.text.toString()
       // binding.textView.text="Name: ${userLogin}"
    }



}