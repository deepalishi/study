package com.techdata.study.ui

sealed class Routes(val routes: String) {
    data object Home: Routes("Home")
    data object Profile: Routes("Profile")
    data object Setting: Routes("Settings")
}
