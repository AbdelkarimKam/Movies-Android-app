package com.yassir.challenge.movies.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yassir.challenge.movies.data.repository.IMoviesRepository
import com.yassir.challenge.movies.model.Movie
import com.yassir.challenge.movies.domain.GetMovieByIdUseCase
import com.yassir.challenge.movies.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: IMoviesRepository,
    private val getMovieByIdUseCase: GetMovieByIdUseCase

) : ViewModel() {

    val pagingMovieFlow: Flow<PagingData<Movie>> =
        repository.getSearchResultStream().cachedIn(viewModelScope)

    private val _movieState: MutableStateFlow<Resource<Movie>> by lazy {
        MutableStateFlow(Resource.loading(null))
    }
    val movieState: StateFlow<Resource<Movie>>
        get() = _movieState.asStateFlow()

    fun setStateEvent(uiEvent: UiEvent) {
        if (uiEvent is UiEvent.GetMovieEvent) {
            getMovieByIdUseCase.invoke(uiEvent.id)
                .onEach { _movieState.emit(it) }
                .launchIn(viewModelScope)
        }
    }

}
