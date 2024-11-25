package ru.wb.ui.ui.screens.events.submit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.ui.R
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentBottomButtons
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentTitle
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun SubmitEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    label: String = "",
    id: String = "",
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fake_background),
            contentDescription = "background",
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(top = 20.dp, bottom = 28.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            AppointmentTitle(
                modifier = Modifier,
                description = label,
                title = stringResource(id = R.string.label_enter_on_meet_ended),
                isEnded = true,
                textColor = AppTheme.colors.neutralColorBackground,
            )
            AppointmentBottomButtons(
                modifier = Modifier,
                secondaryButtonText = if(id.isNotBlank()) stringResource(id = R.string.label_my_meets) else "",
                primaryButtonText = stringResource(id = R.string.text_find_another),
                onEnterClick = { navController.navigate(Screen.EVENTS.route) },
                onTextButtonClick = {
                    if(id.isNotBlank()) {
                        navController.navigate(Screen.PROFILE_VIEW_INSIDE_DETAIL.route + "/$id")
                    } else { Unit }
                }
            )
        }
    }
}