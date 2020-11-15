package com.example.randomcats

// import android.R

import android.R.attr.path
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView

import com.squareup.picasso.Picasso
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.MemoryPolicy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.cat)

        val button = findViewById<View>(R.id.generate_cat)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                // Do some work here
                 val url = "https://loremflickr.com/1080/720/cat"
               // val url = "https://picsum.photos/500/300"
                //val url = "https://loremflickr.com/cache/resized/"
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.nice_cat)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .into(imageView)

                Log.i("RandomCat", "Load a new cat from loremflickr")

            }

        })
    }
}