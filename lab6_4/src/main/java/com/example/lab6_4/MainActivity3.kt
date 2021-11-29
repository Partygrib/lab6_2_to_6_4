package com.example.lab6_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val urlImage = URL("https://img05.rl0.ru/afisha/" +
            "e1200x600i/daily.afisha.ru/uploads/images/c/db/" +
            "cdb4b9e3a65e7a45ed35d9068f126257.png")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        imageView = findViewById(R.id.imageView1)
        loadCoolImage()
    }

    private fun loadCoolImage() {
        Glide.with(this).load(urlImage.toString()).into(imageView)
    }
}