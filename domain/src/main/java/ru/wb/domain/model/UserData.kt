package ru.wb.domain.model

data class UserData(
    val id: String,
    val icon: String? = null,
    val firstName: String,
    val lastName: String? = null,
    val story: Boolean = false,
    val status: Boolean = false,
    val phone: String,
    val role: List<String>? = null,
    val socialMedia: List<SocialMedia>,
    val description: String? = null,
){
    companion object{
        val defaultObject = UserData(
            id = "",
            firstName = "Павел",
            lastName = "Хориков",
            icon = "https://i.pinimg.com/736x/68/66/8b/68668baa3fc2881be05b907ab5c02ba8.jpg",
            story = false,
            status = false,
            phone = "",
            socialMedia = listOf(),
            role = listOf("Developer"),
            description = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС."
        )
    }
}
