// Generated by Dagger (https://dagger.dev).
package com.moviedb.ui.home;

import com.moviedb.domain.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MovieListViewModel_Factory implements Factory<MovieListViewModel> {
  private final Provider<ApiService> apiServiceProvider;

  public MovieListViewModel_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public MovieListViewModel get() {
    return newInstance(apiServiceProvider.get());
  }

  public static MovieListViewModel_Factory create(Provider<ApiService> apiServiceProvider) {
    return new MovieListViewModel_Factory(apiServiceProvider);
  }

  public static MovieListViewModel newInstance(ApiService apiService) {
    return new MovieListViewModel(apiService);
  }
}