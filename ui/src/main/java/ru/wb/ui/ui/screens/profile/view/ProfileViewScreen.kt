package ru.wb.ui.ui.screens.profile.view

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.R
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.ui.ui.screens.profile.components.ProfileViewCard

@Composable
internal fun ProfileViewScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewScreenViewModel = koinViewModel()
){
    val userData: UserData by viewModel.getUserFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()

    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                navController.popBackStack()
            }
        },
        iconRight = R.drawable.ic_edit,
        onRightIconClick = { navController.navigate(Screen.PROFILE_EDIT.route) },
        text = Screen.PROFILE_VIEW.label
    )

    BaseScreen(
        modifier = modifier,
        state = state
    ) {
        ProfileViewCard(
            modifier = modifier,
            userData = userData
        )
    }
}