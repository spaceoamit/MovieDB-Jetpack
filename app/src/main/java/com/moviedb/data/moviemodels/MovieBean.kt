package com.moviedb.data.moviemodels

data class MovieBean(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)