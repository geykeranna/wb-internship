package ru.testtask.testapplication.ui.component.toolbars

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.theme.subheading1

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    iconRight: Int? = null,
    onRightIconClick: () -> Unit = {},
    iconLeft: Int? = null,
    onLeftIconClick: () -> Unit = {},
    text: String = ""
) {
    Box(
        modifier = modifier
            .padding(vertical = 16.dp)
            .height(30.dp)
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
                            .size(24.dp)
                            .clickable { onLeftIconClick() }
                            .align(Alignment.CenterVertically),
                        painter = painterResource(iconLeft),
                        contentDescription = "left button"
                    )
                }
                Text(
                    text = text,
                    style = MaterialTheme.typography.subheading1,
                )
            }

            iconRight?.let {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onRightIconClick() }
                        .align(Alignment.CenterVertically),
                    painter = painterResource(iconRight),
                    contentDescription = "left button"
                )
            }
        }
    }
}