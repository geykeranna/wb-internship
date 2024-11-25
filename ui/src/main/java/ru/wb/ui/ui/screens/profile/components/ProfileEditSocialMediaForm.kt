package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.SocialMedia
import ru.wb.ui.R
import ru.wb.ui.ui.component.input.InputField
import ru.wb.ui.ui.component.utils.defaultSocialMediaMap

@Composable
internal fun ProfileEditSocialMediaForm(
    socialMedia: List<SocialMedia>,
    modifier: Modifier = Modifier,
    onChangeValue: (key: String, text: String) -> Unit = { _, _ -> },
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        socialMedia.map { item ->
            val icon = defaultSocialMediaMap.getOrDefault(item.name) { R.drawable.ic_help_circle }

            InputField(
                modifier = modifier,
                iconLeft = painterResource(id = icon as Int),
                value = item.url,
                onChangeValue = { text ->
                    onChangeValue(item.id, text)
                },
            )
        }
    }
}