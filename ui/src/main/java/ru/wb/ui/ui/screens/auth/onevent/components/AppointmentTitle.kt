package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AppointmentTitle(
    eventLabel: String,
    modifier: Modifier = Modifier,
    title: String = "",
    onCloseClick: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ){
            Text(
                modifier = Modifier.fillMaxWidth(0.8f),
                style = AppTheme.typography.large1,
                text = title,
                overflow = TextOverflow.Visible,
            )
            Image(
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onCloseClick() },
                painter = painterResource(id = R.drawable.ic_close_big),
                contentDescription = "close button"
            )
        }
        Text(
            modifier = Modifier,
            style = AppTheme.typography.subheading3,
            text = eventLabel,
        )
    }
}