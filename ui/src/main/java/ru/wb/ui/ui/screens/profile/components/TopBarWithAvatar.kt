package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.toolbars.TopBarDetail

@Composable
internal fun TopBarWithAvatar(
    src: String?,
    modifier: Modifier = Modifier,
    pageMode: ProfilePageMode = ProfilePageMode.VIEW_OUTSIDE,
    onNavigate: () -> Unit = {},
    onShare: () -> Unit = {},
    onPageModeChange: (newPageMode: ProfilePageMode) -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp),
    ) {
        ProfileImage(
            modifier = Modifier.fillMaxSize(),
            src = src,
        )

        when(pageMode) {
            ProfilePageMode.VIEW_INSIDE -> {
                TopBarDetail(
                    modifier = Modifier,
                    rightIcon = painterResource(id = R.drawable.ic_edit),
                    onLeftClick = onNavigate,
                    onRightClick = { onPageModeChange(ProfilePageMode.EDIT) },
                )
            }
            ProfilePageMode.EDIT -> {
                TopBarDetail(
                    modifier = Modifier,
                    rightIcon = painterResource(id = R.drawable.ic_check_big),
                    leftIcon = painterResource(id = R.drawable.ic_close_big),
                    onLeftClick = { onPageModeChange(ProfilePageMode.VIEW_INSIDE) },
                    onRightClick = { onPageModeChange(ProfilePageMode.VIEW_INSIDE) },
                )
            }
            else -> {
                TopBarDetail(
                    modifier = Modifier,
                    onLeftClick = onNavigate,
                    onRightClick = onShare,
                )
            }
        }
    }
}