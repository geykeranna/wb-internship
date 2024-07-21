package ru.wb.testapplication.ui.screens.profile.view

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.testapplication.R
import ru.wb.domain.model.UserData
import ru.wb.testapplication.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.testapplication.ui.screens.profile.components.ProfileViewCard

@Composable
fun ProfileViewScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewScreenViewModel = koinViewModel()
){
    val userData: UserData = viewModel.getUser().collectAsState().value

    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                navController.popBackStack()
            }
        },
        iconRight = R.drawable.ic_edit,
        onRightIconClick = { navController.navigate(Screen.ProfileEdit.route) },
        text = Screen.ProfileView.name
    )

    ProfileViewCard(
        modifier = modifier,
        userData = userData
    )
}