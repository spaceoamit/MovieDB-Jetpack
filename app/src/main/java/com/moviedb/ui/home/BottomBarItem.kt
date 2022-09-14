package com.moviedb.ui.home

import com.moviedb.R

/**
 * @Author: Amit Patoliya
 * @Date: 08/09/22
 */

sealed class BottomBarItem(var title:String, var icon:Int, var route:String){

    object NowPlaying : BottomBarItem("Movie", R.drawable.ic_movies,"movies")
    object Popular: BottomBarItem("TV", R.drawable.ic_tv,"tv")
    object UpComing: BottomBarItem("Profile", R.drawable.ic_profiles,"profiles")
}
