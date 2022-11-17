package com.yassir.challenge.movies.domain

import com.yassir.challenge.movies.data.repository.IMovieRemoteRepository
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.tools.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

class GetMovieByIdUseCase(
    private val remoteRepository: IMovieRemoteRepository,
    private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int): Flow<Resource<Movie>> = flow {
        emit(Resource.loading(null))
        try {
            val movie = remoteRepository.getMovieById(id)
            emit(Resource.success(movie))
        } catch (e: IOException) {
            emitError(message = e.message)
        } catch (e: HttpException) {
            emitError(message = e.message)
        }
    }.flowOn(ioDispatcher)
}

private suspend fun FlowCollector<Resource<Movie>>.emitError(message: String?) =
    this.emit(Resource.error(null, message = message))
