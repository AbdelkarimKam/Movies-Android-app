package com.yassir.challenge.movies.data.repository

import com.yassir.challenge.movies.data.datasources.retrofit.ApiDataSource
import com.yassir.challenge.movies.data.datasources.retrofit.MovieMapper
import com.yassir.challenge.movies.data.datasources.retrofit.models.MovieDetailsResponse
import com.yassir.challenge.movies.model.Movie
import javax.inject.Inject

class MovieRemoteRepository @Inject constructor(
    private val apiDataSource: ApiDataSource,
    private val movieMapper: MovieMapper
) : IMovieRemoteRepository {
    override suspend fun getMovieById(id: Int): Movie {
        val networkCountries: MovieDetailsResponse = apiDataSource.getMovieById(id)
        return movieMapper.mapFromNetwork(networkCountries)
    }
}
