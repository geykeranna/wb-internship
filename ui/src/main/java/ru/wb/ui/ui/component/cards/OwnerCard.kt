package ru.wb.ui.ui.component.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun OwnerCard(
    owner: Owner,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit = {},
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = owner.title,
            style = AppTheme.typography.subheading1,
            color = AppTheme.colors.neutralColorFont,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(
                    text = title,
                    style = AppTheme.typography.secondary1,
                    color = AppTheme.colors.neutralColorFont,
                )
                Text(
                    text = description,
                    style = AppTheme.typography.secondary,
                    color = AppTheme.colors.neutralColorFont,
                    overflow = TextOverflow.Visible,
                )
            }

            Box { icon() }
        }
    }
}

internal enum class Owner(val title: String) {
    COMMUNITY(title = "Организатор"),
    USER(title = "Владелец")
}