package ru.wb.ui.ui.component.toolbars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.ICON_SIZE_IN_DETAIL_TOP_BAR
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun TopBarDetail(
    modifier: Modifier = Modifier,
    title: String = "",
    leftIcon: Painter? = painterResource(id = R.drawable.ic_back),
    rightIcon: Painter? = painterResource(id = R.drawable.ic_share),
    onLeftClick: () -> Unit = {},
    onRightClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        leftIcon?.let { icon ->
            Icon(
                modifier = Modifier
                    .clickable { onLeftClick() }
                    .size(ICON_SIZE_IN_DETAIL_TOP_BAR.dp),
                painter = icon,
                tint = AppTheme.colors.brandColorDefault,
                contentDescription = "back button"
            )
        }

        Text (
            modifier = Modifier.fillMaxWidth(0.9f),
            text = title,
            style = AppTheme.typography.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )

        rightIcon?.let { icon ->
            Icon(
                modifier = Modifier
                    .clickable { onRightClick() }
                    .size(ICON_SIZE_IN_DETAIL_TOP_BAR.dp),
                painter = icon,
                tint = AppTheme.colors.brandColorDefault,
                contentDescription = "share button"
            )
        }
    }
}