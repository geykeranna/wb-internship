package ru.wb.ui.ui.component.chips

data class ChipsData(
    val id: String,
    val name: String
) {
    companion object {
        val defaultObject = ChipsData(id="0", name = "Все категории")
    }
}
