package com.moviedb.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moviedb.data.tvmodels.Result
import com.moviedb.data.tvmodels.TvBean
import com.moviedb.domain.ApiService
import retrofit2.Response

/**
 * @Author: Amit Patoliya
 * @Date: 29/08/22
 */
class TvSource(private val apiService: ApiService, private val index: Int) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>) = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {

            lateinit var  response : Response<TvBean>
            val nextPage = params.key ?: 1
            when(index){
                0 -> response = apiService.getOntheAirTv(pageNumber = nextPage)
                1 -> response = apiService.getPopularTv(pageNumber = nextPage)
                2 -> response = apiService.getArrivingTodayTv(pageNumber = nextPage)
                3 -> response = apiService.getLatestTv(pageNumber = nextPage)
                4 -> response = apiService.getTopratedTv(pageNumber = nextPage)

            }

            return if (response.isSuccessful && response.body() != null) {
                var tvBean  = response.body()!!
                LoadResult.Page(
                    data = tvBean.results,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = tvBean.page.plus(1)
                )
            }else{
                LoadResult.Error(Exception(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}