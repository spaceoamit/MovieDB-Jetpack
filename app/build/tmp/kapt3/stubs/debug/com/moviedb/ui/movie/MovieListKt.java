package com.moviedb.ui.movie;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0007\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u0010"}, d2 = {"MovieCard", "", "movie", "Lcom/moviedb/data/moviemodels/Result;", "MovieGridScreen", "lazyMovieItems", "Landroidx/paging/compose/LazyPagingItems;", "MovieList", "movies", "ShowMovieList", "viewModel", "Lcom/moviedb/ui/home/MovieListViewModel;", "TabsContent", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "TextTabs", "app_debug"})
public final class MovieListKt {
    
    /**
     * @Author: Amit Patoliya
     * @Date: 08/09/22
     */
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void ShowMovieList(@org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.MovieListViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void TabsContent(@org.jetbrains.annotations.NotNull()
    com.google.accompanist.pager.PagerState pagerState, @org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.MovieListViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MovieGridScreen(@org.jetbrains.annotations.NotNull()
    androidx.paging.compose.LazyPagingItems<com.moviedb.data.moviemodels.Result> lazyMovieItems) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void MovieList(@org.jetbrains.annotations.NotNull()
    androidx.paging.compose.LazyPagingItems<com.moviedb.data.moviemodels.Result> movies) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MovieCard(@org.jetbrains.annotations.NotNull()
    com.moviedb.data.moviemodels.Result movie) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void TextTabs(@org.jetbrains.annotations.NotNull()
    com.google.accompanist.pager.PagerState pagerState) {
    }
}