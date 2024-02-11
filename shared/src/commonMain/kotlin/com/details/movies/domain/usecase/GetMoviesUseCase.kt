package com.details.movies.domain.usecase

import com.details.movies.domain.model.Movie
import com.details.movies.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMoviesUseCase:KoinComponent{
    private val repository: MovieRepository by inject()
    @Throws(Exception::class)//disable internet connection
    suspend operator fun invoke(page:Int):List<Movie> {

        return repository.getMovies(page = page)
    }
}