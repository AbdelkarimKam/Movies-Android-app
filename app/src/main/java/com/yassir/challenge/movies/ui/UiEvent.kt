package com.yassir.challenge.movies.ui

sealed class UiEvent {
    object GetMoviesEvent : UiEvent()
    data class GetMovieEvent(val id: Int) : UiEvent()
}

