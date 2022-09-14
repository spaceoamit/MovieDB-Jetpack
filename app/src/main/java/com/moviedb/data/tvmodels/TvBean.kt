package com.moviedb.data.tvmodels

data class TvBean(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)