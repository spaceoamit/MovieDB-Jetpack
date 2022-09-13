package com.moviedb.domain

import com.moviedb.data.moviemodels.MovieBean

/**
 * @Author: Amit Patoliya
 * @Date: 29/08/22
 */
sealed class NetworkResult {
    data class Success(val data: MovieBean) : NetworkResult()
    data class Error(val message: String) : NetworkResult()
    object Loading : NetworkResult()
}