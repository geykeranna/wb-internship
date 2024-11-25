package ru.wb.ui.ui.screens.profile.components

import ru.wb.domain.model.SocialMedia

data class ProfileFormState(
    val name: String,
    val phone: String,
    val location: String,
    val description: String,
    val tags: List<String>,
    val socials: List<SocialMedia>,
    val isShowCommunity: Boolean,
    val isShowEvent: Boolean,
    val enableNotification: Boolean,
)