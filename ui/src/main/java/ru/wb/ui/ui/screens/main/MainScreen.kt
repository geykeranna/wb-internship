package ru.wb.ui.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.component.navigation.NavGraph
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.utils.NoRippleTheme

@Composable
internal fun MainScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val isAuth by viewModel.getStateFlow().collectAsStateWithLifecycle()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        Screen.SPLASH.route -> bottomBarState.value = false
        else -> bottomBarState.value = true
    }

    Scaffold(
        modifier = Modifier,
        containerColor = Color.White,
    ) { padding ->
        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ){
                NavGraph(
                    isAuth = isAuth,
                    navController = navController
                )
            }
        }
    }
}