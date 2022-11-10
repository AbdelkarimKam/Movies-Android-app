package com.yassir.challenge.movies.data.datasources.retrofit

import com.yassir.challenge.movies.data.datasources.retrofit.models.MovieDetailsResponse
import com.yassir.challenge.movies.data.datasources.retrofit.models.MoviesResponse
import com.yassir.challenge.movies.tools.Constant.MOVIE
import com.yassir.challenge.movies.tools.Constant.MOVIES
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiDataSource {
    @GET(MOVIES)
    suspend fun getMovies(@Query("page") page: Int): MoviesResponse

    @GET("$MOVIE{movie_id}")
    suspend fun getMovieById(@Path("movie_id") id: Int): MovieDetailsResponse
}
