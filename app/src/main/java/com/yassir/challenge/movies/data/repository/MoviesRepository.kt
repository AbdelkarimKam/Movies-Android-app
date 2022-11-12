package com.yassir.challenge.movies.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yassir.challenge.movies.data.datasources.retrofit.ApiDataSource
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.data.pagingsource.MoviePagingSource
import kotlinx.coroutines.flow.Flow

class MoviesRepository(
    private val service: ApiDataSource
) : IMoviesRepository {
    @ExperimentalPagingApi
    override fun getSearchResultStream(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(service) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}
