package com.example.imagegallery

data class ImageModel(
    val id: String,
    val urls: Urls
)
data class Urls(
    val small: String
)
