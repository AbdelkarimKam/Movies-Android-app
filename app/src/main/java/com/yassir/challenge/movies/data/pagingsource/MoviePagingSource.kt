package com.yassir.challenge.movies.data.pagingsource

import androidx.paging.*
import com.yassir.challenge.movies.data.datasources.retrofit.ApiDataSource
import com.yassir.challenge.movies.data.datasources.retrofit.MoviesMapper
import com.yassir.challenge.movies.data.datasources.retrofit.models.MoviesResponse
import com.yassir.challenge.movies.model.Movie
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class MoviePagingSource(
    private val networkService: ApiDataSource
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            // val response: MoviesResponse = networkService.getMovies(position, params.loadSize)
            val response: MoviesResponse = networkService.getMovies(position)
            val movies = MoviesMapper().mapFromEntityList(response)
            val nextKey = if (response == null) {
                null
            } else {
                position + 1
            }
            LoadResult.Page(
                data = movies,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (e: IOException) {

            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
