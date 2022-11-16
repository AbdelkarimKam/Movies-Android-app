package com.yassir.challenge.movies.tools

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl", "movieId")
fun bindImage(imgView: ImageView, imgUrl: String?, movieId: Int) {
    imgUrl?.let {
        // todo move this code to servirce
        val imgUri =
            ("https://image.tmdb.org/t/p/w500/$it").toUri().buildUpon()
                .scheme("https")
                .build()
        imgView.load(imgUri)
    }
}
