package com.example.coroutinesproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowToast.setOnClickListener {
            Toast.makeText(this,"UI Thread",Toast.LENGTH_LONG).show()
        }
        binding.btnClicked.setOnClickListener {
            lifecycleScope.launch {
                for(i in 1..100000)
                {
                    delay(1000L)
                    Log.d("MainActivity","count i :$i")
                    binding.tvText.text=i.toString()
                }
            }
            GlobalScope.launch {
                delay(10000L)
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
                finish()
            }
        }
    }
}