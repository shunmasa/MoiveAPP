package com.details.movies.domain.repository

import com.details.movies.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(page:Int):List<Movie>
    suspend fun getMovie(movieId:Int):Movie
}