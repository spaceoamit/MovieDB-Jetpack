package com.moviedb.ui.tv;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000bH\u0007\u001a\u0016\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007\u00a8\u0006\u0010"}, d2 = {"ShowTvShowList", "", "viewModel", "Lcom/moviedb/ui/home/MovieListViewModel;", "TabsTvShowsContent", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "TextTvTabs", "TvGridScreen", "lazyMovieItems", "Landroidx/paging/compose/LazyPagingItems;", "Lcom/moviedb/data/tvmodels/Result;", "TvShowCard", "tvshowBean", "TvShowList", "tvshows", "app_debug"})
public final class TvShowListKt {
    
    /**
     * @Author: Amit Patoliya
     * @Date: 08/09/22
     */
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void ShowTvShowList(@org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.MovieListViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void TabsTvShowsContent(@org.jetbrains.annotations.NotNull()
    com.google.accompanist.pager.PagerState pagerState, @org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.MovieListViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TvGridScreen(@org.jetbrains.annotations.NotNull()
    androidx.paging.compose.LazyPagingItems<com.moviedb.data.tvmodels.Result> lazyMovieItems) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void TvShowList(@org.jetbrains.annotations.NotNull()
    androidx.paging.compose.LazyPagingItems<com.moviedb.data.tvmodels.Result> tvshows) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TvShowCard(@org.jetbrains.annotations.NotNull()
    com.moviedb.data.tvmodels.Result tvshowBean) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void TextTvTabs(@org.jetbrains.annotations.NotNull()
    com.google.accompanist.pager.PagerState pagerState) {
    }
}