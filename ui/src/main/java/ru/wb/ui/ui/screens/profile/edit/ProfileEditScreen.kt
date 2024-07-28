package ru.wb.ui.ui.screens.profile.edit

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.R
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.ui.ui.screens.profile.components.ProfileEditCard

@Composable
internal fun ProfileEditScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = { navController.popBackStack() },
    viewModel: ProfileEditScreenViewModel = koinViewModel()
){
    val formField by viewModel.formFields.collectAsStateWithLifecycle()
    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = { onBackClick() },
        text = Screen.ProfileView.name
    )

    ProfileEditCard(
        modifier = modifier,
        formField = formField,
        state = viewModel.getState(),
        onValueChange = { index, text ->
            viewModel.obtainEvent(
                ProfileEditScreenViewModel.Event.OnChangeFieldData(
                    index = index,
                    input = text
                )
            )
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