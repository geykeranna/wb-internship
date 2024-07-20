package ru.testtask.testapplication.ui.screens.profile.edit

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.screens.profile.components.ProfileEditCard

@Composable
fun ProfileEditScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {
        if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
            navController.popBackStack()
        }
    },
    viewModel: ProfileEditScreenViewModel = koinViewModel()
){
    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = { onBackClick() },
        text = Screen.ProfileView.name
    )

    ProfileEditCard(
        modifier = modifier,
        formField = viewModel.formFields,
        state = viewModel.getState(),
        onClick = {
            if(viewModel.getState()){
                viewModel.obtainEvent(ProfileEditScreenViewModel.Event.OnSetData)
                navController.navigate(Screen.Events.route)
            }
        }
    )
}