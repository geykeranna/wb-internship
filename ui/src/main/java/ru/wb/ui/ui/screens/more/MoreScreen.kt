package ru.wb.ui.ui.screens.more

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.ui.R
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.toolbars.MenuItem
import ru.wb.ui.ui.component.toolbars.MenuItemUser
import ru.wb.ui.ui.component.toolbars.TopBarCustom
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_SPACE_BY_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun MoreScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    TopBarCustom (
        modifier = Modifier
            .padding(start = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp),
        label = Screen.MORE.label
    )

    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp)
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_SPACE_BY_CONTENT_COMMON.dp)
    ) {
        item {
            MenuItemUser(
                userData = UserData.defaultObject,
                onClickItem = {
                    navController.navigate(Screen.PROFILE_VIEW.route)
                }
            )
        }

        item {
            MenuItem(
                iconLeft = R.drawable.ic_coffee,
                onClickItem = {
                    navController.navigate(Screen.MY_EVENTS.route)
                },
                text = stringResource(R.string.label_menu_items_my_meets),
                iconRight = R.drawable.ic_chevron_right
            )
        }

        item {
            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickItem = { },
                text = stringResource(R.string.label_menu_items_theme),
                iconLeft = R.drawable.ic_sun
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickItem = { },
                text = stringResource(R.string.label_menu_items_notification),
                iconLeft = R.drawable.ic_notification
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickItem = { },
                text = stringResource(R.string.label_menu_items_privacy),
                iconLeft = R.drawable.ic_outline_privacy_tip
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickItem = { },
                text = stringResource(R.string.label_menu_items_folder),
                iconLeft = R.drawable.ic_folder
            )

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = AppTheme.colors.neutralColorDivider
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickItem = { },
                text = stringResource(R.string.label_menu_items_help),
                iconLeft = R.drawable.ic_help_circle
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickItem = { },
                text = stringResource(R.string.label_menu_items_referral),
                iconLeft = R.drawable.ic_mail
            )
        }
    }
}