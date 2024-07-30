package ru.wb.ui.ui.component.toolbars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.wb.ui.ui.component.navigation.NavBar
import ru.wb.ui.ui.component.utils.Constants.PADDING_BOTTOM_IN_BOTTOM_BAR
import ru.wb.ui.ui.component.utils.Constants.PADDING_HORIZONTAL_IN_BOTTOM_BAR
import ru.wb.ui.ui.component.utils.Constants.PADDING_TOP_IN_BOTTOM_BAR
import ru.wb.ui.ui.component.utils.NoRippleTheme

@Composable
internal fun BottomNavBar(
    navController: NavHostController,
    state: MutableState<Boolean>,
){
    val screens = listOf(
        NavBar.Event,
        NavBar.Community,
        NavBar.More
    )

    val navStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackEntry?.destination

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        AnimatedVisibility(
            visible = state.value,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it }),
        ){
            Row(
                modifier = Modifier
                    .padding(horizontal = PADDING_HORIZONTAL_IN_BOTTOM_BAR.dp)
                    .padding(top = PADDING_TOP_IN_BOTTOM_BAR.dp, bottom = PADDING_BOTTOM_IN_BOTTOM_BAR.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                screens.forEach { screen ->
                    BarItem(
                        screen,
                        currentDestination,
                        navController
                    )
                }
            }
        }
    }
}