package com.example.sympleintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.ActivityResult
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sympleintent.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var aciIntent = Intent(this,MainActivity2::class.java)
        intent.putExtra( "name","filipe")
        intent.putExtra("age",12)

        val acitivyResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result:ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK){
                    val intent = result.data
                    if(intent?.hasExtra("result") == true){
                        Snackbar.make(
                            binding.root,
                            intent.getStringExtra("result")?: "",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
            }
        }


        binding.btn1.setOnClickListener {
            acitivyResult.launch(aciIntent)
        }
    }
}