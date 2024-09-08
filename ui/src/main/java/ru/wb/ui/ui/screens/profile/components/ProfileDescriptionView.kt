package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ProfileDescriptionView(
    userData: UserData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = userData.name,
            style = AppTheme.typography.large2,
            color = AppTheme.colors.neutralColorFont,
        )
        Column (
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ){
            Text(
                text = userData.location,
                style = AppTheme.typography.heading4,
                color = AppTheme.colors.neutralColorFont,
            )
            Text(
                text = userData.description,
                style = AppTheme.typography.secondary,
                color = AppTheme.colors.neutralColorFont,
            )
        }
    }
}