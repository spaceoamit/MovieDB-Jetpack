package com.moviedb.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a,\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\nH\u0007\u001a&\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u00a8\u0006\u0014"}, d2 = {"BottomBar", "", "navController", "Landroidx/navigation/NavHostController;", "MainScreenView", "viewmodel", "Lcom/moviedb/ui/home/MovieListViewModel;", "NavigationGraph", "onHeaderChange", "Lkotlin/Function1;", "", "PreviewUI", "SampleScreen", "message", "AddItem", "Landroidx/compose/foundation/layout/RowScope;", "screen", "Lcom/moviedb/ui/home/BottomBarItem;", "currentDestination", "Landroidx/navigation/NavDestination;", "app_debug"})
public final class MainActivityKt {
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.ui.tooling.preview.Preview()
    public static final void PreviewUI() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SampleScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MainScreenView(@org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.MovieListViewModel viewmodel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NavigationGraph(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.MovieListViewModel viewmodel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onHeaderChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BottomBar(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AddItem(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.RowScope $this$AddItem, @org.jetbrains.annotations.NotNull()
    com.moviedb.ui.home.BottomBarItem screen, @org.jetbrains.annotations.Nullable()
    androidx.navigation.NavDestination currentDestination, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController) {
    }
}