package br.com.entrypoint.mycinemalistyt.data.remote.dto

import br.com.entrypoint.mycinemalistyt.domain.PopularMovie
import com.google.gson.annotations.SerializedName
data class PopularMovieDto(
        val id: Long,
        val title: String,
        val overview: String,
        @SerializedName ( value = "release_date")
        val releaseDate: String,
        @SerializedName( value = "vote_average")
        val voteAverage: Double,
){
        fun toPopularMovie() : PopularMovie{
                return PopularMovie(
                        id = id,
                        title = title,
                        description = overview,
                        voteAverage = voteAverage
                )
        }
}




