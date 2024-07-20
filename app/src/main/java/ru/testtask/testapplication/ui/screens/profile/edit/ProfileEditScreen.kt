package ru.testtask.testapplication.ui.screens.profile.edit

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    onBackClick: () -> Unit = { navController.popBackStack() },
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
        onValueChange = { index, text ->
            viewModel.setFieldData(index = index, input = text)
        },
        onClick = {
            if(viewModel.getState()){
                navController.navigate(Screen.Events.route){
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
                viewModel.obtainEvent(ProfileEditScreenViewModel.Event.OnSetData)
            }
        }
    )
}