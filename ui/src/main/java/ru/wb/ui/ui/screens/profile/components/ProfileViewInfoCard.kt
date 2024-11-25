package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.chips.SocialChips
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON

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
            modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
            userData = userData,
        )

        TagsChips(
            modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
            data = userData.tags,
        )

        SocialChips(
            modifier = Modifier,
            list = userData.socialMedia
        )
    }
}