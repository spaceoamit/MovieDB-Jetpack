package com.moviedb.data.profilemodels

data class ProfileBean(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)