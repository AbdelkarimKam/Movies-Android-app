package com.yassir.challenge.movies.ui

import androidx.recyclerview.widget.RecyclerView
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.databinding.MovieViewholderBinding

class MovieViewHolder (
    private val binding: MovieViewholderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.apply {
            binding.title.text = movie.title.toString()
            binding.overview.text = movie.overview.toString()
            binding.voteAverage.text = movie.voteAverage.toString()
        }
    }
}