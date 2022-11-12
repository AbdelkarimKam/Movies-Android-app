package com.yassir.challenge.movies.tools

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.yassir.challenge.movies.tools.Constant.BASE_URL

@BindingAdapter("imageUrl", "movieId")
fun bindImage(imgView: ImageView, imgUrl: String?, movieId: Int) {
    imgUrl?.let {
        imgUrl?.let {
            // todo move this code to servirce to call with api_key Attention this code don't work
            val imgUri =
                imgUrl.toUri().buildUpon().scheme("$BASE_URL/movie/{$movieId}/images").build()
            imgView.load(imgUri)
        }
    }
}
