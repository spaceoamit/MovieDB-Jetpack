package com.moviedb.ui.home;

import java.lang.System;

/**
 * @Author: Amit Patoliya
 * @Date: 08/09/22
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u0082\u0001\u0003\u0015\u0016\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/moviedb/ui/home/BottomBarItem;", "", "title", "", "icon", "", "route", "(Ljava/lang/String;ILjava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getRoute", "()Ljava/lang/String;", "setRoute", "(Ljava/lang/String;)V", "getTitle", "setTitle", "NowPlaying", "Popular", "UpComing", "Lcom/moviedb/ui/home/BottomBarItem$NowPlaying;", "Lcom/moviedb/ui/home/BottomBarItem$Popular;", "Lcom/moviedb/ui/home/BottomBarItem$UpComing;", "app_debug"})
public abstract class BottomBarItem {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    private int icon;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String route;
    
    private BottomBarItem(java.lang.String title, int icon, java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getIcon() {
        return 0;
    }
    
    public final void setIcon(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    public final void setRoute(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/moviedb/ui/home/BottomBarItem$NowPlaying;", "Lcom/moviedb/ui/home/BottomBarItem;", "()V", "app_debug"})
    public static final class NowPlaying extends com.moviedb.ui.home.BottomBarItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.moviedb.ui.home.BottomBarItem.NowPlaying INSTANCE = null;
        
        private NowPlaying() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/moviedb/ui/home/BottomBarItem$Popular;", "Lcom/moviedb/ui/home/BottomBarItem;", "()V", "app_debug"})
    public static final class Popular extends com.moviedb.ui.home.BottomBarItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.moviedb.ui.home.BottomBarItem.Popular INSTANCE = null;
        
        private Popular() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/moviedb/ui/home/BottomBarItem$UpComing;", "Lcom/moviedb/ui/home/BottomBarItem;", "()V", "app_debug"})
    public static final class UpComing extends com.moviedb.ui.home.BottomBarItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.moviedb.ui.home.BottomBarItem.UpComing INSTANCE = null;
        
        private UpComing() {
            super(null, 0, null);
        }
    }
}