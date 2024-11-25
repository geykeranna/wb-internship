package ru.wb.ui.ui.component.chips

enum class ChipsSize(
    val paddingTop: Int,
    val paddingBottom: Int,
    val paddingLeft: Int,
    val paddingRight: Int,
) {
    SMALL(
        paddingRight = 6,
        paddingBottom = 3,
        paddingTop = 2,
        paddingLeft = 6,
    ),
    NORMAL(
        paddingRight = 8,
        paddingBottom = 8,
        paddingTop = 8,
        paddingLeft = 8,
    ),
    LARGE(
        paddingRight = 12,
        paddingBottom = 10,
        paddingTop = 10,
        paddingLeft = 12,
    )
}