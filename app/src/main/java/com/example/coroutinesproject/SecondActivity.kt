package com.example.coroutinesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesproject.databinding.ActivityMainBinding
import com.example.coroutinesproject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}