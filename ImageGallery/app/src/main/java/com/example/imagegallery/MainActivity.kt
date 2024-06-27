package com.example.imagegallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        imageAdapter = ImageAdapter()

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = imageAdapter

        fetchImages()
    }

    private fun fetchImages() {
        RetrofitInstance.api.getImages().enqueue(object : Callback<List<ImageModel>> {
            override fun onResponse(call: Call<List<ImageModel>>, response: Response<List<ImageModel>>) {
                if (response.isSuccessful) {
                    response.body()?.let { images ->
                        imageAdapter.setImages(images)
                    }
                }
            }

            override fun onFailure(call: Call<List<ImageModel>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
