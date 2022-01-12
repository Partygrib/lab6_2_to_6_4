package com.example.lab6_3

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val urlImage = URL("https://img05.rl0.ru/afisha/" +
            "e1200x600i/daily.afisha.ru/uploads/images/c/db/" +
            "cdb4b9e3a65e7a45ed35d9068f126257.png")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        imageView = findViewById(R.id.imageView1)
        loadCoolImage()
    }

    private fun loadCoolImage() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Working thread1: ", Thread.currentThread().name)
            val image = BitmapFactory.decodeStream(urlImage.openStream())
            withContext(Dispatchers.Main) {
                imageView.setImageBitmap(image)
                Log.d("Working thread2: ", Thread.currentThread().name)
            }
        }
    }
}