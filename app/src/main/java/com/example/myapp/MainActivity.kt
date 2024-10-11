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
    var gettingName: String? =null




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

        gettingName=sharedPreferences.getString("Name: ",  "")
        if (gettingName==""){
            binding.textView.text="Saved name: "
        }
        else{
            binding.textView.text="Saved name: ${gettingName}"
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

        if (username == "") {
            // Kullanıcı isim girmediyse uyarı mesajı göster
            Toast.makeText(this@MainActivity, "Do not leave your name!", Toast.LENGTH_LONG).show()
        } else {
            // Kullanıcı isim girdiyse AlertDialog oluştur
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Save")
            alert.setMessage("Are you sure to save?")

            alert.setPositiveButton("Yes") { dialog, which ->
                // İsim kaydediliyor
                sharedPreferences.edit().putString("Name: ", username).apply()
                binding.textView.text = "Saved name: ${username}"
                Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_LONG).show()
            }

            alert.setNegativeButton("No") { dialog, which ->
                Toast.makeText(this@MainActivity, "Not saved", Toast.LENGTH_LONG).show()
            }

            // Dialog'u göster
            alert.show()
        }
    }

    fun delete(view: View){
        gettingName=sharedPreferences.getString("name", "")
        if (gettingName !=""){
            sharedPreferences.edit().remove("name").apply()
        }
        binding.textView.text="Saved name: "
    }





}