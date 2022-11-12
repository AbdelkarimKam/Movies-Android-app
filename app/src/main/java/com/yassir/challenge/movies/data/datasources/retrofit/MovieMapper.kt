package com.yassir.challenge.movies.data.datasources.retrofit

import com.yassir.challenge.movies.data.datasources.retrofit.models.MovieDetailsResponse
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.tools.NetworkMapper
import javax.inject.Inject

class MovieMapper @Inject constructor() : NetworkMapper<MovieDetailsResponse, Movie> {

    override fun mapFromNetwork(network: MovieDetailsResponse): Movie {
        return Movie(
            id = network.id,
            originalTitle = network.originalTitle,
            overview = network.overview,
            popularity = network.popularity,
            posterPath = network.posterPath,
            releaseDate = network.releaseDate,
            title = network.title,
            voteAverage = network.voteAverage
        )
    }
}
