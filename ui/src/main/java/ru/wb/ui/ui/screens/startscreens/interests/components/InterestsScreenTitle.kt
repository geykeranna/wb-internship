package ru.wb.ui.ui.screens.startscreens.interests.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun InterestsScreenTitle(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.label_interesting),
            style = AppTheme.typography.large1,
            color = AppTheme.colors.neutralColorFont,
        )

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.label_interesting_description),
            style = AppTheme.typography.regular,
            color = AppTheme.colors.neutralColorFont,
        )
    }
}