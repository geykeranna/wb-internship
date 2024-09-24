package ru.wb.ui.ui.screens.startscreens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import ru.wb.ui.ui.component.navigation.Screen

@Composable
internal fun SplashScreen(
    isAuth: Boolean,
    navController: NavController,
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
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DotLottieAnimation(
            source = DotLottieSource.Asset("splash_screen.json"),
            autoplay = true,
            loop = true
        )
    }
}