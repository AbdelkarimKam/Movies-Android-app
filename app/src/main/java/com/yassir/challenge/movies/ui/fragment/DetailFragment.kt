package com.yassir.challenge.movies.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.lifecycle.lifecycleScope
import com.yassir.challenge.movies.databinding.MovieDetailsLayoutBinding
import com.yassir.challenge.movies.tools.Status
import com.yassir.challenge.movies.tools.displayError
import com.yassir.challenge.movies.tools.displayLoading
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@ExperimentalComposeApi
@AndroidEntryPoint
class DetailFragment : BaseFragment<MovieDetailsLayoutBinding>(MovieDetailsLayoutBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.movieState.collectLatest {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { movie -> binding.movie = movie }
                    }
                    Status.FAILURE -> {
                        displayError(_context, it.message)
                    }
                    Status.LOADING -> {
                        displayLoading(_context)
                    }
                }
            }
        }
    }
}
