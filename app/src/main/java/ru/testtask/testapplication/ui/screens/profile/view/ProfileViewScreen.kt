package ru.testtask.testapplication.ui.screens.profile.view

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.screens.profile.components.ProfileViewCard

@Composable
fun ProfileViewScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
){
    val userData: UserData = UserData.shimmerData

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