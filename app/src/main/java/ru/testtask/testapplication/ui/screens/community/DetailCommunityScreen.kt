package ru.testtask.testapplication.ui.screens.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.ui.component.toolbars.TopBar

@Composable
fun DetailCommunityScreen(
    modifier: Modifier = Modifier
) {
    val detailInfo = CommunityData.shimmerData
    val textState = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(horizontal = 24.dp),

    ) {
        TopBar(
            modifier = Modifier,
            iconLeft = R.drawable.ic_chevron_left,
            text = detailInfo.label,
        )

        DetailCommunityScreen(
        )
    }
}