package ru.wb.ui.ui.screens.profile.delete

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.R
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentTitle
import ru.wb.ui.ui.screens.profile.delete.components.DeleteProfileButtons
import ru.wb.ui.ui.screens.profile.delete.DeleteProfileViewScreenViewModel.Event

@Composable
internal fun DeleteProfileViewScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: DeleteProfileViewScreenViewModel = koinViewModel()
){
    LazyColumn(
        modifier = modifier
            .padding(top = 20.dp, bottom = 28.dp)
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        item{
            AppointmentTitle(
                description = stringResource(id = R.string.text_on_delete_mess),
                title = stringResource(id = R.string.text_delete_message),
                modifier = Modifier,
                onCloseClick = { navController.popBackStack() },
            )
        }
        
        item {
            DeleteProfileButtons(
                modifier = Modifier,
                onDeleteProfileClick = { viewModel.obtainEvent(Event.OnDeleteUser) },
                onCancelClick = { navController.popBackStack() },
            )
        }
    }
}