package ru.testtask.testapplication.ui.component.cards.visitors

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.avatars.UserAvatar
import ru.testtask.testapplication.ui.theme.bodyText1

@Composable
fun VisitorsList(
    modifier: Modifier = Modifier,
    visitorsList: List<UserData> = listOf(),
    onClick: () -> Unit = {},
    showAvatarsNum: Int = 5,
    overlappingPercentage: Float = 0.35f,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        val factor = (1 - overlappingPercentage)

        if (visitorsList.isNotEmpty()) {
            Row(
                modifier = Modifier.clickable { onClick() },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Layout(
                    content = {
                        visitorsList.take(showAvatarsNum).forEach { visitors ->
                            UserAvatar(
                                src = visitors.icon,
                                story = visitors.story,
                                status = visitors.status
                            )
                        }
                    },
                    measurePolicy = { measurable, constraints ->
                    val placeable = measurable.map { it.measure(constraints) }
                    val widthsExceptFirst = placeable.subList(1, placeable.size).sumOf { it.width }
                    val firstWidth = placeable.getOrNull(0)?.width ?: 0
                    val width = (widthsExceptFirst * factor + firstWidth).toInt()
                    val height = placeable.maxOf { it.height }
                    layout(width, height) {
                        var x = 0
                        placeable.forEachIndexed { index, placed ->
                            placed.placeRelative(
                                x, 0, (placeable.size - index).toFloat()
                            )
                            x += (placed.width * factor).toInt()
                        }
                    }
                })

                if (visitorsList.size > showAvatarsNum) {
                    Text(
                        text = "+${visitorsList.size - 5}",
                        style = MaterialTheme.typography.bodyText1
                    )
                }
            }
        }
    }
}