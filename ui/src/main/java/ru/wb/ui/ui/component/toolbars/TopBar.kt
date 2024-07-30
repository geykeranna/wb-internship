package ru.wb.testapplication.ui.component.toolbars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import ru.wb.ui.ui.theme.NeutralActiveColor
import ru.wb.ui.ui.theme.subheading1

@Composable
internal fun TopBar(
    modifier: Modifier = Modifier,
    text: String = "",
    iconRight: Int? = null,
    iconLeft: Int? = null,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {},
    tintRightIcon: Color = NeutralActiveColor,
    tintLeftIcon: Color = NeutralActiveColor,
    textColor: Color = NeutralActiveColor
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
                            .clickable { onLeftIconClick() }
                            .align(Alignment.CenterVertically),
                        painter = painterResource(iconLeft),
                        contentDescription = "left button",
                        tint = tintLeftIcon
                    )
                }
                Text(
                    text = text,
                    style = MaterialTheme.typography.subheading1,
                    color = textColor
                )
            }

            iconRight?.let {
                Icon(
                    modifier = Modifier
                        .size(ICON_SIZE_IN_TOP_BAR.dp)
                        .clickable { onRightIconClick() }
                        .align(Alignment.CenterVertically),
                    painter = painterResource(iconRight),
                    contentDescription = "right button",
                    tint = tintRightIcon
                )
            }
        }
    }
}