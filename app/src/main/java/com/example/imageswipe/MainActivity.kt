package com.example.imageswipe

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.example.imageswipe.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

private lateinit var binding: ActivityMainBinding
private lateinit var gallery: Gallery
private var counter: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gallery = Gallery()
        counter = 0

        binding.textView.setOnTouchListener { _, m: MotionEvent ->
            handleTouch(m)
            true
        }
        switchImage()
    }

    private fun handleTouch(m: MotionEvent){
        val action = m.actionMasked
        when(action) {
            MotionEvent.ACTION_DOWN -> switchImage()
            //MotionEvent.ACTION_UP -> switchImage()
            //MotionEvent.ACTION_POINTER_DOWN -> switchImage()
            //MotionEvent.ACTION_POINTER_UP -> switchImage()
            //MotionEvent.ACTION_MOVE -> switchImage()
        }
    }

    private fun switchImage(){
        GlobalScope.launch {
            val imageUrl = gallery.urls.get(counter % gallery.urls.size)
            val description = gallery.descriptions.get(counter % gallery.descriptions.size)
            counter += 1

            try {
                val httpConnection = imageUrl.openConnection() as HttpURLConnection
                httpConnection.doInput = true
                httpConnection.connect()

                val inputStream = httpConnection.inputStream
                val bitmapImage = BitmapFactory.decodeStream(inputStream)

                //runOnUiThread {
                //    binding.imageView.setImageBitmap(bitmapImage)
                //}
                Handler(mainLooper).post {
                    binding.imageView.setImageBitmap(bitmapImage)
                    binding.textView.text = description
                }
            } catch (e: Exception){
                Log.e("MAIN ACTIVITY", "Error Loading Image")
            }
        }
    }
}