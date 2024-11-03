package ru.wb.ui.ui.screens.startscreens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.wb.ui.R
import ru.wb.ui.ui.component.navigation.Screen

@Composable
internal fun SplashScreen(
    isAuth: Boolean,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) {
        delay(3000)
        if(isAuth) {
            navController.navigate(Screen.INTEREST.route) {
                popUpTo(Screen.SPLASH.route) { inclusive = true }
            }
        }
        else {
            navController.navigate(Screen.INTEREST.route) {
                popUpTo(Screen.SPLASH.route) { inclusive = true }
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//        DotLottieAnimation(
//            source = DotLottieSource.Asset("splash_screen.json"),
//            autoplay = true,
//            loop = true
//        )
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash_screen),
            contentDescription = "splash screen"
        )
    }
}