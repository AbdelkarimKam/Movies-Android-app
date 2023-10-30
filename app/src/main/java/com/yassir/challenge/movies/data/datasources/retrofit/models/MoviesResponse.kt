package com.yassir.challenge.movies.data.datasources.retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("results")
    @Expose
    val movieResponses: List<MovieResponse>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)
