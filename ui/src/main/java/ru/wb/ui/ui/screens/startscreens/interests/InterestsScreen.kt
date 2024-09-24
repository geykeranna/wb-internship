package ru.wb.ui.ui.screens.startscreens.interests

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.screens.startscreens.interests.components.InterestsScreenBottomBar
import ru.wb.ui.ui.screens.startscreens.interests.components.InterestsScreenMain
import ru.wb.ui.ui.screens.startscreens.interests.InterestsScreenViewModel.Event

@Composable
internal fun InterestsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: InterestsScreenViewModel = koinViewModel()
) {
    val state by viewModel.getState().collectAsStateWithLifecycle()
    val options by viewModel.getOptions().collectAsStateWithLifecycle()
    val selected by viewModel.getSelected().collectAsStateWithLifecycle()

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { navController.navigate(Screen.EVENTS.route) },
    )

    Scaffold(
        modifier = Modifier
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp)
            .padding(top = 20.dp, bottom = 28.dp),
        bottomBar = {
            InterestsScreenBottomBar(
                modifier = modifier,
                disabled = selected.isEmpty(),
                onTextClick = { locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION) },
            ){
                viewModel.obtainEvent(Event.OnEnterClick)
                locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    ) { padding ->
        BaseScreen(
            modifier = Modifier.padding(padding),
            state = state
        ) {
            InterestsScreenMain(
                modifier = Modifier,
                options = options,
                selectedList = selected,
            ) { newValue ->
                viewModel.obtainEvent(Event.OnSelect(newValue))
            }
        }
    }
}