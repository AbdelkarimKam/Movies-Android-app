package com.yassir.challenge.movies.di

import com.yassir.challenge.movies.data.datasources.retrofit.ApiDataSource
import com.yassir.challenge.movies.data.datasources.retrofit.MovieMapper
import com.yassir.challenge.movies.data.repository.IMovieRemoteRepository
import com.yassir.challenge.movies.data.repository.IMoviesRepository
import com.yassir.challenge.movies.data.repository.MovieRemoteRepository
import com.yassir.challenge.movies.data.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideMoviesRepository(
        apiDataSource: ApiDataSource
    ): IMoviesRepository {
        return MoviesRepository(
            apiDataSource
        )
    }

    @ViewModelScoped
    @Provides
    fun provideMovieRemoteRepository(
        apiDataSource: ApiDataSource,
        movieMapper: MovieMapper
    ): IMovieRemoteRepository {
        return MovieRemoteRepository(
            apiDataSource,
            movieMapper
        )
    }
}