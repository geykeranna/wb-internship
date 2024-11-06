package ru.wb.domain.model

data class CommunityItemData(
    val id: String,
    val label: String,
    val icon: String?,
    val description: String,
    val isVerified: Boolean,
    val isSubscribed: Boolean,
    val tags: List<String>,
){
    companion object {
        val defaultObject = CommunityItemData(
            id = "1",
            label = "The IT-Crowd",
            icon = null,
            description = "Сообщество профессионалов в сфере IT.",
            isVerified = false,
            isSubscribed = false,
            tags = listOf("Разработка")
        )
    }
}
