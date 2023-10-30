package com.yassir.challenge.movies.data.repository

import androidx.paging.PagingData
import com.yassir.challenge.movies.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {
    fun getSearchResultStream(): Flow<PagingData<Movie>>
}