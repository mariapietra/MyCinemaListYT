package br.com.entrypoint.mycinemalistyt.data.remote

import android.telecom.Call
import br.com.entrypoint.mycinemalistyt.data.remote.response.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {
    @GET(value = "3/movie/popular")
    fun getPopularMovies(
        @Query(value = "api_key") api: String = API_KEY

    ) : Call <PopularMovieResponse>

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_KEY = "6d4d157bbdb1b020d609885ae39b94a1"
    }
}