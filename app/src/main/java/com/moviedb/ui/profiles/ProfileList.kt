package com.moviedb.ui.profiles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.moviedb.ErrorItem
import com.moviedb.LoadingItem
import com.moviedb.LoadingView
import com.moviedb.R
import com.moviedb.data.profilemodels.Result
import com.moviedb.ui.home.MovieListViewModel


/**
 * @Author: Amit Patoliya
 * @Date: 13/09/22
 */

@Composable
fun ShowProfileList(viewModel: MovieListViewModel){

    val profiles = viewModel.popularProfiles.collectAsLazyPagingItems()

    Surface{
        LazyColumn (contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
            items(profiles.itemCount) { item ->
                profiles[item]?.let { ProfileCard(it) }
            }

            profiles.apply {
                when {

                    loadState.refresh is LoadState.Loading -> {
                        item() { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                    }
                    loadState.append is LoadState.Loading -> {
                        item() { LoadingItem() }
                    }
                    loadState.refresh is LoadState.Error -> {
                        val e = profiles.loadState.refresh as LoadState.Error
                        item() {
                            ErrorItem(
                                message = e.error.localizedMessage!!,
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }

                    }
                    loadState.append is LoadState.Error -> {
                        val e = profiles.loadState.append as LoadState.Error
                        item() {
                            ErrorItem(
                                message = e.error.localizedMessage!!,
                                onClickRetry = { retry() }
                            )
                        }
                    }
                }
            }

        }

    }

}


@Composable
fun ProfileCard(profileBean: Result){

    Box( modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
        .height(80.dp)) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            elevation = 5.dp
        ) {

            Row{

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w200/${profileBean.profile_path}")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_place_holder),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxHeight()
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)) {

                    Text(
                        text = profileBean.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = profileBean.known_for_department,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,

                    )

                }
                



            }


        }

    }


}
