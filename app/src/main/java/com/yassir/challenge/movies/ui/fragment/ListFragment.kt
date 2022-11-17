package com.yassir.challenge.movies.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yassir.challenge.movies.R
import com.yassir.challenge.movies.databinding.MoviesLayoutBinding
import com.yassir.challenge.movies.ui.MovieAdapter
import com.yassir.challenge.movies.ui.UiEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalComposeApi
@AndroidEntryPoint
class ListFragment : BaseFragment<MoviesLayoutBinding>(MoviesLayoutBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieAdapter = MovieAdapter()
        binding.bindAdapter(movieAdapter = movieAdapter)

        with(viewLifecycleOwner.lifecycleScope) {
            this.launchWhenStarted {
                mainViewModel.pagingMovieFlow.collectLatest {
                    movieAdapter.submitData(it)
                }
            }
            this.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    movieAdapter.loadStateFlow.collectLatest {
                        binding.prependProgress.isVisible = it.source.prepend is LoadState.Loading
                        binding.appendProgress.isVisible = it.source.append is LoadState.Loading
                    }
                }
            }
        }

        movieAdapter.onItemClick = { countryId ->
            mainViewModel.setStateEvent(UiEvent.GetMovieEvent(countryId))
            displayFragmentCountry()
        }
    }

    private fun displayFragmentCountry() =
        findNavController().navigate(R.id.action_listFragment_to_detailFragment)

    private fun MoviesLayoutBinding.bindAdapter(movieAdapter: MovieAdapter) {
        list.apply {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(false)
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }
}
