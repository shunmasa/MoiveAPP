package com.details.movies.data.remote
@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    //all movie lists
    val results:List<MovieRemote>
)

