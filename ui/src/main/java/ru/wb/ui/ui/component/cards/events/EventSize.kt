package ru.wb.ui.ui.component.cards.events

import ru.wb.ui.ui.component.utils.Constants.WIDTH_OF_THIN_IMAGE_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.WIDTH_OF_WIDE_IMAGE_IN_EVENT_CARD

internal enum class EventSize(val width: Int) {
    THIN(WIDTH_OF_THIN_IMAGE_IN_EVENT_CARD),
    WIDE(WIDTH_OF_WIDE_IMAGE_IN_EVENT_CARD),
}