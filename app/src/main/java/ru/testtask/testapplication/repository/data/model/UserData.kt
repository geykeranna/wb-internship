package ru.testtask.testapplication.repository.data.model

data class UserData(
    var id: String?,
    var icon: String?,
    var firstName: String,
    var lastName: String,
    val story: Boolean?,
    var status: Boolean?,
    var phone: String?,
    var socialMedia: List<SocialMedia>
){
    companion object{
        val shimmerData = UserData(
            id = null,
            firstName = "",
            lastName = "",
            icon = null,
            story = null,
            status = null,
            phone = null,
            socialMedia = listOf()
        )
    }
}
