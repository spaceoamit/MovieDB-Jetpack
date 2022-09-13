package com.moviedb.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.moviedb.ui.movie.ShowMovieList
import com.moviedb.ui.profiles.ShowProfileList
import com.moviedb.ui.theme.MyApplicationTheme
import com.moviedb.ui.tv.ShowTvShowList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                //ShowMovieList(viewmodel)
                MainScreenView(viewmodel)
            }
        }
    }
}


@Preview
@Composable
fun PreviewUI() {
    MyApplicationTheme {
        Surface {
            //MainScreenView(viewmodel)
        }
    }
}



@Composable
fun SampleScreen(message:String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = message,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MainScreenView(viewmodel: MovieListViewModel) {
    val navController = rememberNavController()

    var headerText = rememberSaveable {
        mutableStateOf("Now Playing Movies")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(headerText.value) },
                elevation = 0.dp
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        },
        content = {

                Box(modifier = Modifier.padding(it)) {
                    NavigationGraph(navController = navController, viewmodel = viewmodel,onHeaderChange = { headerText.value = it })
                }
        }
    )
}

@Composable
fun NavigationGraph(navController: NavHostController, viewmodel:MovieListViewModel, onHeaderChange: (String) -> Unit) {
    NavHost(navController, startDestination = BottomBarItem.NowPlaying.route) {
        composable(BottomBarItem.NowPlaying.route) {
            ShowMovieList(viewmodel)
            onHeaderChange.invoke("Movies")

        }
        composable(BottomBarItem.Popular.route) {
            ShowTvShowList(viewmodel)
            onHeaderChange.invoke("Tv shows")
        }
        composable(BottomBarItem.UpComing.route) {
            ShowProfileList(viewmodel)
            onHeaderChange.invoke("Profiles")

        }

    }
}



@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarItem.NowPlaying,
        BottomBarItem.Popular,
        BottomBarItem.UpComing
    )
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination

        screens.forEach { item ->
            AddItem(
                screen = item,
                currentDestination = currentRoute,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen:BottomBarItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    BottomNavigationItem(
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
                )
               },
        label = { Text(text = screen.title,
            fontSize = 12.sp) },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(alpha = 0.3f),
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route } == true,
        onClick = {


            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                    inclusive = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
    )
}