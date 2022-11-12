package com.yassir.challenge.movies.data.datasources.retrofit

import com.yassir.challenge.movies.data.datasources.retrofit.models.MovieResponse
import com.yassir.challenge.movies.data.datasources.retrofit.models.MoviesResponse
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.tools.NetworkMapper
import javax.inject.Inject

class MoviesMapper @Inject constructor() : NetworkMapper<MovieResponse, Movie> {

    override fun mapFromNetwork(network: MovieResponse): Movie {
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

    fun mapFromEntityList(entities: MoviesResponse): List<Movie> {
        return entities.movieResponses.map {
            mapFromNetwork(it)
        }
    }
}
