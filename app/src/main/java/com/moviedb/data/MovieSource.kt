package com.moviedb.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moviedb.data.moviemodels.MovieBean
import com.moviedb.data.moviemodels.Result
import com.moviedb.domain.ApiService
import retrofit2.Response

/**
 * @Author: Amit Patoliya
 * @Date: 29/08/22
 */
class MovieSource(private val apiService: ApiService, private val index: Int) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>) = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {

            lateinit var  response : Response<MovieBean>
            val nextPage = params.key ?: 1
            when(index){
                0 -> response = apiService.getNowPlayingMovies(pageNumber = nextPage)
                1 -> response = apiService.getPopularMovies(pageNumber = nextPage)
                2 -> response = apiService.getUpComingMovies(pageNumber = nextPage)
                3 -> response = apiService.getLatestMovies(pageNumber = nextPage)
                4 -> response = apiService.getTopratedMovies(pageNumber = nextPage)

            }

            return if (response.isSuccessful && response.body() != null) {

                var movieBean  = response.body()!!

                LoadResult.Page(
                    data = movieBean.results,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = movieBean.page.plus(1)
                )
            }else{
                LoadResult.Error(Exception(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}