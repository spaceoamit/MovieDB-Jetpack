package com.moviedb.ui.home

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.moviedb.domain.ApiService
import com.moviedb.data.MovieSource
import com.moviedb.data.ProfileSource
import com.moviedb.data.TvSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Amit Patoliya
 * @Date: 24/08/22
 */
@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val apiService: ApiService
): ViewModel() {



    // Movies
    val playing: Flow<PagingData<com.moviedb.data.moviemodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        MovieSource(apiService, 0)
    }.flow

    val popular: Flow<PagingData<com.moviedb.data.moviemodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        MovieSource(apiService, 1)
    }.flow

    val upcoming: Flow<PagingData<com.moviedb.data.moviemodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        MovieSource(apiService, 2)
    }.flow

    val latest: Flow<PagingData<com.moviedb.data.moviemodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        MovieSource(apiService, 3)
    }.flow

    val toprated: Flow<PagingData<com.moviedb.data.moviemodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        MovieSource(apiService, 4)
    }.flow


    //Tv

    val onAirTv: Flow<PagingData<com.moviedb.data.tvmodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        TvSource(apiService, 0)
    }.flow

    val popularTv: Flow<PagingData<com.moviedb.data.tvmodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        TvSource(apiService, 1)
    }.flow

    val arrivingTv: Flow<PagingData<com.moviedb.data.tvmodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        TvSource(apiService, 2)
    }.flow

    val latestTv: Flow<PagingData<com.moviedb.data.tvmodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        TvSource(apiService, 3)
    }.flow

    val topratedTv: Flow<PagingData<com.moviedb.data.tvmodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        TvSource(apiService, 4)
    }.flow


    // Popular persons

    val popularProfiles: Flow<PagingData<com.moviedb.data.profilemodels.Result>> = Pager(PagingConfig(pageSize = 20)) {
        ProfileSource(apiService)
    }.flow


}