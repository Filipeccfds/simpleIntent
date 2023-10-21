package com.example.sympleintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sympleintent.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent?.extras?.isEmpty == false){
            val name = intent.getStringExtra("name")
        }

        val result = Intent()
        result.putExtra("result","valor da result chamada")
        setResult(RESULT_OK,result)
        finish()
    }
}