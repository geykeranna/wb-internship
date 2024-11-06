package ru.wb.domain.model

data class UserData(
    val id: String,
    val icon: String? = null,
    val name: String,
    val story: Boolean = false,
    val status: Boolean = false,
    val phone: String,
    val location: String = "",
    val role: List<String>? = null,
    val socialMedia: List<SocialMedia> = listOf(),
    val tags: List<String> = listOf(),
    val description: String = "",
    val isShowCommunity: Boolean = true,
    val isShowEvent: Boolean = true,
    val enableNotification: Boolean = true,
    val communities: List<CommunityItemData>? = null,
    val events: List<EventItemData>? = null,
){
    companion object{
        val defaultObject = UserData(
            id = "1",
            name = "Павел Хориков",
            icon = "https://i.pinimg.com/736x/68/66/8b/68668baa3fc2881be05b907ab5c02ba8.jpg",
            story = false,
            status = false,
            phone = "",
            socialMedia = List(10) {SocialMedia.defaultObject},
            role = listOf("Developer"),
            description = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
            location = "Moscow",
            tags = listOf("Python", "Backend", "Developer"),
            communities = null,
            events = null,
        )
    }
}
