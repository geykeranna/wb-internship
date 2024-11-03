package ru.wb.ui.ui.component.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun LoadingSpinner() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = AppTheme.colors.brandColorDefault,
            strokeWidth = 4.dp,
        )
    }
}