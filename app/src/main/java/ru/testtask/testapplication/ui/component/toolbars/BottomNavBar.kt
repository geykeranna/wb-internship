package ru.testtask.testapplication.ui.component.toolbars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.component.navigation.NavBar
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_TAB_ITEM_BOTTOM_BAR
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_BOTTOM_IN_BOTTOM_BAR
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_HORIZONTAL_IN_BOTTOM_BAR
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_TEXT_IN_BOTTOM_BAR
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_TOP_IN_BOTTOM_BAR
import ru.testtask.testapplication.ui.component.utils.Constants.WIDTH_TAB_ITEM_BOTTOM_BAR
import ru.testtask.testapplication.ui.component.utils.NoRippleTheme

@Composable
fun BottomNavBar(
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


@Composable
fun BarItem(
    screen: NavBar,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route?.contains(screen.route) ?: false } == true

    Column (
        modifier = Modifier
            .height(HEIGHT_TAB_ITEM_BOTTOM_BAR.dp)
            .width(WIDTH_TAB_ITEM_BOTTOM_BAR.dp)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!selected) {
            Icon(
                painter = painterResource(screen.icon),
                contentDescription = screen.label
            )
        }
        AnimatedVisibility(visible = selected) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(bottom = PADDING_TEXT_IN_BOTTOM_BAR.dp),
                    text = screen.label,
                )
                Icon(
                    painter = painterResource(R.drawable.ic_choisen),
                    contentDescription = null
                )
            }
        }
    }
}