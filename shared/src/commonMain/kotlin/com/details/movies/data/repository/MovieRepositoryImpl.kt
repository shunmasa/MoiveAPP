package com.details.movies.data.repository

import com.details.movies.data.remote.RemoteDataSource
import com.details.movies.domain.model.Movie
import com.details.movies.domain.repository.MovieRepository
import com.details.movies.data.util.toMovie
internal class MovieRepositoryImpl(
    private val remoteDateSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDateSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDateSource.getMovie(movieId = movieId).toMovie()
    }
}