package ru.testtask.testapplication.ui.screens.more

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.toolbars.MenuItem
import ru.testtask.testapplication.ui.component.toolbars.MenuItemUser
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.theme.NeutralLineColor

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TopBar (
            modifier = Modifier
                .padding(start = 8.dp),
            text = "Ещё"
        )

        MenuItemUser(
            userData = UserData.shimmerData,
            onClickRightIcon = {}
        )

        MenuItem(
            iconLeft = R.drawable.ic_coffee,
            onClickRightIcon = { },
            text = "Мои встречи",
            iconRight = R.drawable.ic_chevron_right
        )

        Column {
            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickRightIcon = { },
                text = "Тема",
                iconLeft = R.drawable.ic_sun
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickRightIcon = { },
                text = "Уведомления",
                iconLeft = R.drawable.ic_notification
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickRightIcon = { },
                text = "Безопасность",
                iconLeft = R.drawable.ic_outline_privacy_tip
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickRightIcon = { },
                text = "Память и ресурсы",
                iconLeft = R.drawable.ic_folder
            )

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = NeutralLineColor
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickRightIcon = { },
                text = "Помощь",
                iconLeft = R.drawable.ic_help_circle
            )

            MenuItem(
                iconRight = R.drawable.ic_chevron_right,
                onClickRightIcon = { },
                text = "Пригласи друга",
                iconLeft = R.drawable.ic_mail
            )
        }
    }
}