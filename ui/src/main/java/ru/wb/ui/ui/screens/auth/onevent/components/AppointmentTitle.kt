package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AppointmentTitle(
    eventLabel: String,
    modifier: Modifier = Modifier,
    title: String = "",
    textColor: Color = AppTheme.colors.neutralColorFont,
    isEnded: Boolean = false,
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
                modifier = Modifier.fillMaxWidth(if(!isEnded) 0.8f else 1f),
                style = AppTheme.typography.large1.copy(lineHeight = 44.sp),
                text = title,
                color = textColor,
                overflow = TextOverflow.Visible,
            )
            if(!isEnded) {
                Image(
                    modifier = Modifier
                        .size(28.dp)
                        .noRippleClickable { onCloseClick() },
                    painter = painterResource(id = R.drawable.ic_close_big),
                    contentDescription = "close button"
                )
            }
        }
        Text(
            modifier = Modifier,
            style = AppTheme.typography.subheading3,
            text = eventLabel,
            color = textColor,
        )
    }
}