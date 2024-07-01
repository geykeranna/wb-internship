package ru.testtask.testapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.rememberNavController
import ru.testtask.testapplication.ui.component.navigation.NavGraph
import ru.testtask.testapplication.ui.component.toolbars.BottomNavBar
import ru.testtask.testapplication.ui.component.utils.NoRippleTheme
import ru.testtask.testapplication.ui.theme.TestApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestApplicationTheme {
                val focusManager = LocalFocusManager.current
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            }, indication = null
                        ) {
                            focusManager.clearFocus()
                        },
                    bottomBar = { BottomNavBar(navController) },
                    containerColor = Color.White,
                ) { padding ->
                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(padding)
                        ){
                            NavGraph(navController)
                        }
                    }
                }
            }
        }
    }
}

