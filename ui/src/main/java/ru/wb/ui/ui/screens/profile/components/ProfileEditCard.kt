package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.SocialMedia
import ru.wb.ui.R
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsSize
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ProfileEditCard(
    allChipsList: List<String>,
    allSocialMedia: List<SocialMedia>,
    formField: ProfileFormState,
    modifier: Modifier = Modifier,
    selectedChips: List<String> = listOf(),
    onChipLastItemClick: () -> Unit = {},
    onDeleteButtonClick: () -> Unit = {},
    onSelectChip: (newValue: String) -> Unit = {},
    onValueChange: (key: Int, value: Any) -> Unit = {_, _ -> },
) {
    val lastItem = stringResource(id = R.string.text_add_with_plus)

    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ProfileEditUserForm(
                formFields = formField,
                onValueChange = onValueChange
            )
        }

        item {
            LabeledCard(
                label = stringResource(id = R.string.label_interesting)
            ) {
                ChipsGroup(
                    data = allChipsList + lastItem,
                    size = ChipsSize.NORMAL,
                    selectedList = selectedChips,
                    onChangeSelect = { newValue ->
                        when(newValue){
                            lastItem -> onChipLastItemClick()
                            else -> onSelectChip(newValue)
                        }
                    },
                )
            }
        }

        if (allSocialMedia.isNotEmpty()) {
            item {
                LabeledCard(
                    label = stringResource(id = R.string.label_socials)
                ) {
                    ProfileEditSocialMediaForm(
                        socialMedia = allSocialMedia,
                        onChangeValue = {index, text ->
                            onValueChange(5, Pair(index, text))
                        },
                    )
                }
            }
        }

        item {
            ProfileEditSettingsValue(
                modifier = Modifier.fillMaxWidth(),
                formField = formField,
                onValueChange = onValueChange,
            )
        }

        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .noRippleClickable { onDeleteButtonClick() },
                    color = AppTheme.colors.accentError,
                    maxLines = 1,
                    style = AppTheme.typography.primary,
                    text = stringResource(id = R.string.label_delete_profile),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}