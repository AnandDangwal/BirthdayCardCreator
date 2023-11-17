package com.example.birthdaywishingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.birthdaywishingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btCreateBirthdayCard.setOnClickListener {
//            val content : String = binding.etYourName.editableText.toString()
//            Toast.makeText(this, "This is $content",Toast.LENGTH_SHORT).show()
//        }

        binding.btCreateBirthdayCard.setOnClickListener {
            val name = binding.etYourName.editableText.toString()

            //Jumping from Main acitivity to Birthday greeting activity.
            val intent = Intent(this, BirthdayGreetingActivity::class.java)

            //Passing data from MainActivity to BirthdayGreetingActivity.
            intent.putExtra(BirthdayGreetingActivity.USER_NAME,name)
            startActivity(intent)
        }

    }

}