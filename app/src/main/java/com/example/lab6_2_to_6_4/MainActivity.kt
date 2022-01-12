package com.example.lab6_2_to_6_4

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Executors
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future


class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var task: Future<*>
    private val executor by lazy { (application as MyApplication).executor }
    private val urlImage = URL("https://img05.rl0.ru/afisha/" +
            "e1200x600i/daily.afisha.ru/uploads/images/c/db/" +
            "cdb4b9e3a65e7a45ed35d9068f126257.png")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView1)
        task = loadCoolImage()
    }

    override fun onDestroy() {
        task.cancel(true)
        super.onDestroy()
    }

    private fun loadCoolImage(): Future<*> {
        return executor.submit {
            Log.d("Working thread1: ", Thread.currentThread().name)
            val image = BitmapFactory.decodeStream(urlImage.openStream())
            imageView.post {
                imageView.setImageBitmap(image)
                Log.d("Working thread2: ", Thread.currentThread().name)
            }
        }
    }
}

class MyApplication : Application() {
    var executor: ExecutorService = Executors.newSingleThreadExecutor()
}

