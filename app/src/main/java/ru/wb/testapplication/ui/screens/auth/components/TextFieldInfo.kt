package ru.wb.testapplication.ui.screens.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.testapplication.ui.component.utils.Constants.CONTENT_PADDING_TEXT_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.HEIGHT_TEXT_INFO_BLOCK_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TEXT_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.theme.bodyText2
import ru.wb.testapplication.ui.theme.heading2

@Composable
fun TextFieldInfo(
    titleText: String,
    descriptionText: String,
    modifier: Modifier = Modifier,
    moreInfo: String? = null,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .height(HEIGHT_TEXT_INFO_BLOCK_LOGIN_SCREEN.dp)
            .padding(horizontal = HORIZONTAL_PADDING_TEXT_IN_LOGIN_SCREEN.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_TEXT_IN_LOGIN_SCREEN.dp),
        userScrollEnabled = false
    ) {
        item {
            Text(
                modifier = Modifier,
                text = titleText,
                style = MaterialTheme.typography.heading2,
                textAlign = TextAlign.Center
            )
        }

        item {
            Text(
                modifier = Modifier
                    .padding(bottom = 2.dp),
                text = descriptionText,
                style = MaterialTheme.typography.bodyText2
                    .copy(lineHeight = 24.sp),
                textAlign = TextAlign.Center
            )

            moreInfo?.let { moreInfo ->
                Text(
                    modifier = Modifier,
                    text = moreInfo,
                    style = MaterialTheme.typography.bodyText2
                        .copy(lineHeight = 24.sp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}