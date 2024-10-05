package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AppointmentEnd(
    modifier: Modifier = Modifier,
    eventLabel: String = "",
    onEnterClick: () -> Unit = {},
    onTextButtonClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fake_background),
            contentDescription = "background",
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(top = 20.dp, bottom = 28.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            item {
                AppointmentTitle(
                    modifier = Modifier,
                    eventLabel = eventLabel.split(" · ").joinToString(separator = "\n"),
                    title = stringResource(id = R.string.label_enter_on_meet_ended),
                    isEnded = true,
                    textColor = AppTheme.colors.neutralColorBackground,
                )
            }
            item {
                AppointmentBottomButtons(
                    modifier = Modifier,
                    secondaryButtonText = stringResource(id = R.string.label_my_meets),
                    primaryButtonText = AppointmentScreenState.END_SCREEN.textButton,
                    onEnterClick = onEnterClick,
                    onTextButtonClick = onTextButtonClick
                )
            }
        }
    }
}