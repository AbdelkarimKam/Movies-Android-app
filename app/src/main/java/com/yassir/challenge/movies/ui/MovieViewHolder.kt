package com.yassir.challenge.movies.ui

import androidx.recyclerview.widget.RecyclerView
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.databinding.MovieViewholderBinding

class MovieViewHolder(
    private val binding: MovieViewholderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
        // This is important, because it forces the data binding to execute immediately,
        // which allows the RecyclerView to make the correct view size measurements
        binding.executePendingBindings()
    }
}