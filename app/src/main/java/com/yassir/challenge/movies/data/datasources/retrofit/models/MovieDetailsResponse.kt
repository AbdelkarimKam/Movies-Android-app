package com.yassir.challenge.movies.data.datasources.retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse( // todo create parent class Movie
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any?,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String?, // todo minLength: 9 maxLength: 9 pattern: ^tt[0-9]{7}
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    @Expose
    val originalTitle: String,
    @SerializedName("overview")
    @Expose
    val overview: String?,
    @SerializedName("popularity")
    @Expose
    val popularity: Double,
    @SerializedName("poster_path")
    @Expose
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    @Expose
    val releaseDate: String?, // todo format:date
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    @Expose
    val status: String, // todo Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)
