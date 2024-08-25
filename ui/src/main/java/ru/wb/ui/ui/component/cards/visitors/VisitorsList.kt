package ru.wb.ui.ui.component.cards.visitors

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.avatars.UserAvatar
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_AVATAR_ROW
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun VisitorsList(
    visitorsList: List<UserData>,
    modifier: Modifier = Modifier,
    onClick: (id: String?) -> Unit = {},
) {
    val density = LocalDensity.current.density
    val countItems = remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { layoutCoordinates ->
                val width = if (visitorsList.isNotEmpty()) layoutCoordinates.size.width else 0
                val dpValueWidth = width / density
                val widthItemsWithOffset = SIZE_USER_AVATAR - SPACE_BY_AVATAR_ROW
                val widthItemsLineWithLastItems = dpValueWidth - SPACE_BY_AVATAR_ROW
                countItems.intValue = (widthItemsLineWithLastItems / widthItemsWithOffset).toInt()
            },
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.spacedBy((-SPACE_BY_AVATAR_ROW).dp),
    ) {
        items(countItems.intValue) { index ->
            Box(
                modifier = Modifier
                    .clickable { onClick(visitorsList[index].id) }
            ) {
                when {
                    index == countItems.intValue - 1 && countItems.intValue < visitorsList.size -> {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(SIZE_USER_AVATAR.dp)
                                .border(
                                    2.dp,
                                    AppTheme.colors.neutralColorBackground,
                                    shape = CircleShape
                                )
                                .background(AppTheme.colors.neutralColorSecondaryBackground)
                            ,
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+${visitorsList.size - countItems.intValue}",
                                color = AppTheme.colors.brandColorDefault,
                                style = AppTheme.typography.userPlusInList
                            )
                        }
                    }
                    else -> {
                        UserAvatar(
                            src = visitorsList[index].icon
                        )
                    }
                }
            }
        }
    }
}