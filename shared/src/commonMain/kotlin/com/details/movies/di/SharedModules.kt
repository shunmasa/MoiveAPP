package com.details.movies.di
import com.details.movies.data.remote.MovieService
import com.details.movies.data.remote.RemoteDataSource
import com.details.movies.data.repository.MovieRepositoryImpl
import com.details.movies.domain.repository.MovieRepository
import com.details.movies.domain.usecase.GetMovieUseCase
import com.details.movies.domain.usecase.GetMoviesUseCase
import com.details.movies.util.provideDispatcher
import org.koin.dsl.module

//factory
private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules