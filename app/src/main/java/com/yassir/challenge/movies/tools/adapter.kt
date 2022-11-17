package com.yassir.challenge.movies.tools

import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.yassir.challenge.movies.R
import com.yassir.challenge.movies.tools.Constant.IMAGE_BASE_URL
import com.yassir.challenge.movies.tools.Constant.SCHEME

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.generateUri()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

private fun String.generateUri(): Uri = ("$IMAGE_BASE_URL$this").toUri().buildUpon().scheme(SCHEME).build()
