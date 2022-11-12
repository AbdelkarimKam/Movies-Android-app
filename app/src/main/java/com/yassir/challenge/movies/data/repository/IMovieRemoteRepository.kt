package com.yassir.challenge.movies.data.repository

import com.yassir.challenge.movies.model.Movie

interface IMovieRemoteRepository {
    suspend fun getMovieById(id: Int): Movie
}