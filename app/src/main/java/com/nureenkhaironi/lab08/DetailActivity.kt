package com.nureenkhaironi.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.nureenkhaironi.lab08.databinding.ActivityDetailBinding
import com.nureenkhaironi.lab08.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.sizeTextView.text = intent.getStringExtra("size")
        binding.pickupDateTextView.text = intent.getStringExtra("date")
        binding.pickupTimeTextView.text = intent.getStringExtra("time")

        binding .sendButton.setOnClickListener{

            binding.ratingTextView.text = binding.ratingBar.rating.toString()


             //show the snackbar after user's rating (Snackbar without button)
            //Snackbar.make(view, "Thank you for your rating, we received it!",
                //Snackbar.LENGTH_LONG).show()

            Snackbar.make(view, "Thank you for your rating, we received it!",
                Snackbar.LENGTH_LONG).setAction("OK"){
                    println("User pressed ok!")
            }.show()
        }


    }
}