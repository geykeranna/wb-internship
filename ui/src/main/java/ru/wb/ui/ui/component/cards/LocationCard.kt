package ru.wb.ui.ui.component.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.Location
import ru.wb.ui.R
import ru.wb.ui.ui.component.avatars.MetroAvatar
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_MAP_SCREEN_DETAIL_EVENT_SCREEN
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_MAP_SCREEN_DETAIL_EVENT_SCREEN
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun LocationCard(
    modifier: Modifier = Modifier,
    data: Location,
    isMapFullScreen: MutableState<Boolean> = mutableStateOf(false),
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ){
            Text(
                text = data.address,
                style = AppTheme.typography.heading2,
                color = AppTheme.colors.neutralColorFont,
                overflow = TextOverflow.Visible
            )

            if (!data.metro.isNullOrEmpty()) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    MetroAvatar(
                        src = data.icon,
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        text = data.metro.orEmpty(),
                        overflow = TextOverflow.Visible,
                        style = AppTheme.typography.secondary
                    )
                }
            }
        }

        Surface(
            modifier = Modifier.height(HEIGHT_MAP_SCREEN_DETAIL_EVENT_SCREEN.dp),
            onClick = { isMapFullScreen.value = true },
            color = Color.White
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(CORNER_RADIUS_MAP_SCREEN_DETAIL_EVENT_SCREEN.dp)),
                painter = painterResource(R.drawable.defaultmap),
                contentDescription = "map",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}