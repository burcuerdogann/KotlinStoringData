package com.burcuerdogan.storingdatakotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.burcuerdogan.storingdatakotlin", Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("Age",-1)

        if (ageFromPreferences == -1){
            textView.text = "Enter Your Age"
        } else{
            textView.text = "Your Age: " + ageFromPreferences
        }
    }

    fun save(view: View){

        val myAge = editText.text.toString().toIntOrNull()

        if (myAge != null){
            textView.text = "Your Age: " + myAge
            sharedPreferences.edit().putInt("Age",myAge).apply()
        }

    }

    fun delete(view: View){

        ageFromPreferences = sharedPreferences.getInt("Age",-1)

        if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("Age").apply()
            textView.text = "Your Age: "
        }

    }

    
}