package ru.wb.ui.ui.component.toolbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_TOP_BAR
import ru.wb.ui.ui.component.utils.Constants.ICON_SIZE_IN_TOP_BAR
import ru.wb.ui.ui.component.utils.Constants.PADDING_VERTICAL_IN_TOP_BAR
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun TopBarCustom(
    modifier: Modifier = Modifier,
    label: String = "",
    iconRight: Int? = null,
    iconLeft: Int? = null,
    tintRightIcon: Color = AppTheme.colors.neutralColorFont,
    tintLeftIcon: Color = AppTheme.colors.neutralColorFont,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .padding(vertical = PADDING_VERTICAL_IN_TOP_BAR.dp)
            .height(HEIGHT_TOP_BAR.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                iconLeft?.let {
                    Icon(
                        modifier = Modifier
                            .size(ICON_SIZE_IN_TOP_BAR.dp)
                            .noRippleClickable { onLeftIconClick() }
                            .align(Alignment.CenterVertically),
                        painter = painterResource(iconLeft),
                        contentDescription = "left button",
                        tint = tintLeftIcon
                    )
                }
                Text(
                    text = label,
                    style = AppTheme.typography.subheading1,
                    color = AppTheme.colors.neutralColorFont
                )
            }

            iconRight?.let {
                Icon(
                    modifier = Modifier
                        .size(ICON_SIZE_IN_TOP_BAR.dp)
                        .noRippleClickable { onRightIconClick() }
                        .align(Alignment.CenterVertically),
                    painter = painterResource(iconRight),
                    contentDescription = "right button",
                    tint = tintRightIcon
                )
            }
        }
    }
}