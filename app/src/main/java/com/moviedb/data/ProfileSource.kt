package com.moviedb.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moviedb.data.profilemodels.ProfileBean
import com.moviedb.data.profilemodels.Result
import com.moviedb.domain.ApiService
import retrofit2.Response

/**
 * @Author: Amit Patoliya
 * @Date: 29/08/22
 */
class ProfileSource(private val apiService: ApiService) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>) = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPage = params.key ?: 1
            val  response : Response<ProfileBean>  = apiService.getPopulerProfiles(pageNumber = nextPage)

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