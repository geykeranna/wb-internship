package ru.wb.ui.ui.component.cards.events

import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_THIN_IMAGE_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_WIDE_IMAGE_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.WIDTH_OF_THIN_IMAGE_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.WIDTH_OF_WIDE_IMAGE_IN_EVENT_CARD

internal enum class EventSize(val width: Int, val height: Int) {
    THIN(WIDTH_OF_THIN_IMAGE_IN_EVENT_CARD, HEIGHT_OF_THIN_IMAGE_IN_EVENT_CARD),
    WIDE(WIDTH_OF_WIDE_IMAGE_IN_EVENT_CARD, HEIGHT_OF_WIDE_IMAGE_IN_EVENT_CARD),
    LARGE(0, HEIGHT_OF_WIDE_IMAGE_IN_EVENT_CARD),
}