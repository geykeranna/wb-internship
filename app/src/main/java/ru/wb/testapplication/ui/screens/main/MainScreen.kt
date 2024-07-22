package ru.wb.testapplication.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.testapplication.ui.component.navigation.NavGraph
import ru.wb.testapplication.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.BottomNavBar
import ru.wb.testapplication.ui.component.utils.NoRippleTheme

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = koinViewModel()
    val isAuth = viewModel.getState().collectAsState().value

    val focusManager = LocalFocusManager.current

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        Screen.Phone.route -> bottomBarState.value = false
        Screen.PinCode.route -> bottomBarState.value = false
        Screen.ProfileFirstEdit.route -> bottomBarState.value = false
        Screen.Splash.route -> bottomBarState.value = false
        else -> bottomBarState.value = true
    }

    Scaffold(
        modifier = Modifier
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                }, indication = null
            ) {
                focusManager.clearFocus()
            },
        bottomBar = {
            BottomNavBar(
                navController = navController,
                state = bottomBarState
            )
        },
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