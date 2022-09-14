package com.moviedb.domain
import com.moviedb.BuildConfig
import com.moviedb.data.moviemodels.MovieBean
import com.moviedb.data.profilemodels.ProfileBean
import com.moviedb.data.tvmodels.TvBean
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Amit Patoliya
 * @Date: 21/06/22
 */

interface ApiService {

    //Movies
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<MovieBean>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<MovieBean>

    @GET("movie/latest")
    suspend fun getLatestMovies(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<MovieBean>

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<MovieBean>

    @GET("movie/top_rated")
    suspend fun getTopratedMovies(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<MovieBean>


    // TV

    @GET("tv/on_the_air")
    suspend fun getOntheAirTv(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<TvBean>

    @GET("tv/popular")
    suspend fun getPopularTv(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<TvBean>

    @GET("tv/airing_today")
    suspend fun getArrivingTodayTv(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<TvBean>


    @GET("tv/latest")
    suspend fun getLatestTv(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<TvBean>

    @GET("tv/top_rated")
    suspend fun getTopratedTv(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<TvBean>


    // persons
    @GET("person/popular")
    suspend fun getPopulerProfiles(
        @Query("api_key") key:String = BuildConfig.API_KEY,
        @Query("page") pageNumber: Int = 1
    ): Response<ProfileBean>


}