package com.example.lab6_3

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
        MainScope().launch {
            val image = withContext(Dispatchers.IO) {
                BitmapFactory.decodeStream(urlImage.openStream())
            }
            imageView.post {
                imageView.setImageBitmap(image)
            }
        }
    }
}