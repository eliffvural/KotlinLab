package com.example.myapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var  sharedPreferences: SharedPreferences




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

        sharedPreferences=this.getSharedPreferences("com.example.myapp",
            Context.MODE_PRIVATE
            )




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

        Toast.makeText(this@MainActivity, "welcome!", Toast.LENGTH_SHORT).show()

        /*
        binding.button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                println("Clicked the button")
            }
        })
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



    fun save(view: View) {
        val username = binding.editText.text.toString()
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Save")
        alert.setMessage("Are you sure to save?")

        // Positive button (Yes)
        alert.setPositiveButton("Yes") { dialog, which ->
            if (username.isEmpty()) {
                Toast.makeText(this@MainActivity, "Do not leave your name empty!", Toast.LENGTH_LONG).show()
            } else {
                sharedPreferences.edit().putString("Name", username).apply()
                binding.textView.text = "Saved name: $username"
                Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_LONG).show()
            }
        }

        // Negative button (No)
        alert.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this@MainActivity, "Not Saved", Toast.LENGTH_LONG).show()
        }

        alert.show()
    }




}