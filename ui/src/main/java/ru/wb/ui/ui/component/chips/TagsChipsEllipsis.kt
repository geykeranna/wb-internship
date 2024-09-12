package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_OF_TEXT_TAGS
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_IN_TAGS_CHIPS

@Composable
fun TagsChipsEllipsis(
    data: List<String>,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current.density
    val spaceByWidth = remember { (SPACE_BY_IN_TAGS_CHIPS * density).toInt() }
    val paddingWidth = remember { (HORIZONTAL_PADDING_OF_TEXT_TAGS * density * 2).toInt() }
    var availableWidth by remember { mutableIntStateOf(0) }
    var countElements by remember { mutableIntStateOf(0) }
    var isVisibleLast by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates -> availableWidth = coordinates.size.width },
        horizontalArrangement = Arrangement.spacedBy(SPACE_BY_IN_TAGS_CHIPS.dp),
    ) {
        if (data.isEmpty()) return@Row

        TagItem(
            modifier = Modifier
                .onGloballyPositioned { layoutCoordinates ->
                    val textWidth = layoutCoordinates.size.width - paddingWidth
                    val elementsData = calculationShowTagsData(
                        data = data.subList(1, data.size),
                        widthCoefficient = textWidth / data.first().length,
                        spaceWidth = spaceByWidth + paddingWidth,
                        availableWidth = availableWidth - layoutCoordinates.size.width,
                    )
                    countElements = elementsData.first
                    isVisibleLast = elementsData.second
                },
            item = data.first(),
        )

        data.subList(1, data.size).take(countElements).forEach { element ->
            TagItem(item = element)
        }

        if(isVisibleLast) {
            TagItem(item = "...")
        }
    }
}

private fun calculationShowTagsData(
    data: List<String>,
    widthCoefficient: Int,
    spaceWidth: Int,
    availableWidth: Int,
): Pair<Int, Boolean> {
    var allWidth = availableWidth
    var count = 0
    var addLast = false
    val widthLastItem = widthCoefficient * 3 + spaceWidth
    data.forEach { tag ->
        val widthTag = tag.length * widthCoefficient + spaceWidth
        when{
            allWidth - widthTag >= 0 || widthTag <= widthLastItem -> {
                allWidth -= widthTag
                count++
            }
            else -> {
                addLast = true
                return@forEach
            }
        }
    }
    return Pair(count, addLast)
}