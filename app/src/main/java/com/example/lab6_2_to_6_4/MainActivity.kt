package com.example.lab6_2_to_6_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Executors
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.net.URL


class MainActivity : AppCompatActivity() {
    private val executorService = Executors.newSingleThreadExecutor()
    private lateinit var imageView: ImageView
    private val urlImage = URL("https://img05.rl0.ru/afisha/" +
            "e1200x600i/daily.afisha.ru/uploads/images/c/db/" +
            "cdb4b9e3a65e7a45ed35d9068f126257.png")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView1)
        loadCoolImage()
    }

    private fun loadCoolImage() {
        executorService.submit {
            val image = BitmapFactory.decodeStream(urlImage.openStream())
            imageView.post {
                imageView.setImageBitmap(image)
            }
        }
    }
}

