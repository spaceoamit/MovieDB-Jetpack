package com.moviedb.ui.movie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.moviedb.ErrorItem
import com.moviedb.LoadingItem
import com.moviedb.LoadingView
import com.moviedb.R
import com.moviedb.data.moviemodels.Result
import com.moviedb.ui.home.MovieListViewModel
import kotlinx.coroutines.launch

/**
 * @Author: Amit Patoliya
 * @Date: 08/09/22
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowMovieList(viewModel: MovieListViewModel) {

    val pagerState = rememberPagerState(pageCount = 5)

    Surface {
        Column {
            TextTabs(pagerState)

            TabsContent(pagerState = pagerState, viewModel)

        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState, viewModel: MovieListViewModel) {



    HorizontalPager(state = pagerState){ page ->

        when(page){
            0 -> {
                val nowplaying = viewModel.playing.collectAsLazyPagingItems()
                MovieGridScreen(nowplaying)
            }
            1-> {
                val popular = viewModel.popular.collectAsLazyPagingItems()
                MovieGridScreen(popular)
            }
            2-> {
                val upcoming = viewModel.upcoming.collectAsLazyPagingItems()
                MovieGridScreen(upcoming)
            }
            3-> {
                val toprated = viewModel.toprated.collectAsLazyPagingItems()
                MovieGridScreen(toprated)
            }

        }

    }




}

@Composable
fun MovieGridScreen(lazyMovieItems: LazyPagingItems<Result>) {
    MovieList(lazyMovieItems)

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieList(movies: LazyPagingItems<Result>) {

    val span: (LazyGridItemSpanScope) -> GridItemSpan = { GridItemSpan(2) }

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(movies.itemCount) { item ->
                movies[item]?.let { MovieCard(it) }
            }

            movies.apply {
                when {

                    loadState.refresh is LoadState.Loading -> {
                        item(span = span) { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                    }
                    loadState.append is LoadState.Loading -> {
                        item(span = span) { LoadingItem() }
                    }
                    loadState.refresh is LoadState.Error -> {
                        val e = movies.loadState.refresh as LoadState.Error
                        item(span = span) {
                            ErrorItem(
                                message = e.error.localizedMessage!!,
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }

                    }
                    loadState.append is LoadState.Error -> {
                        val e = movies.loadState.append as LoadState.Error
                        item(span = span) {
                            ErrorItem(
                                message = e.error.localizedMessage!!,
                                onClickRetry = { retry() }
                            )
                        }
                    }
                }
            }

        })
}


@Composable
fun MovieCard(movie: Result) {

    Box(
        modifier = Modifier
            .fillMaxSize(0.5f)
            .height(200.dp)
            .padding(8.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp
        ) {

            Box(modifier = Modifier.fillMaxSize()) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500/${movie.backdrop_path}")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_place_holder),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                ) {

                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp), contentAlignment = Alignment.BottomStart
                ) {

                    Text(
                        text = movie.title,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(5.dp),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TextTabs(pagerState: PagerState) {

    val tabData = listOf(
        "Now playing",
        "Popular",
        "Upcoming",
        "Top rated"
    )
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,

    ) {
        tabData.forEachIndexed { index, text ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    } },
                text = {
                        Text(text = text)
                     })
        }
    }
}