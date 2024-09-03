package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.chips.SocialChips
import ru.wb.ui.ui.component.chips.TagsChips

@Composable
internal fun ProfileViewInfoCard(
    userData: UserData,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        ProfileDescriptionView(
            modifier = Modifier,
            userData = userData,
        )

        TagsChips(
            modifier = Modifier,
            data = userData.tags,
        )

        SocialChips(
            modifier = Modifier,
            list = userData.socialMedia
        )
    }
}