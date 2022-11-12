package com.yassir.challenge.movies.di

import com.yassir.challenge.movies.data.repository.IMovieRemoteRepository
import com.yassir.challenge.movies.domain.GetMovieByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideGetMovieByIdUseCase(
        iMovieRemoteRepository: IMovieRemoteRepository,
        ioDispatcher: CoroutineDispatcher
    ): GetMovieByIdUseCase {
        return GetMovieByIdUseCase(
            iMovieRemoteRepository, ioDispatcher
        )
    }
}