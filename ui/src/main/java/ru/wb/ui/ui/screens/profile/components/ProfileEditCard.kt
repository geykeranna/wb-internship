package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.SocialMedia
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.chips.ChipsData
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsSize

@Composable
internal fun ProfileEditCard(
    allChipsList: List<ChipsData>,
    allSocialMedia: List<SocialMedia>,
    formField: ProfileFormState,
    modifier: Modifier = Modifier,
    selectedChips: List<ChipsData> = listOf(),
    onSelectChip: (newValue: ChipsData) -> Unit = {},
    onValueChange: (key: Int, value: Any) -> Unit = {_, _ -> },
) {
    LazyColumn (
        modifier = modifier.fillMaxSize(),
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
                label = "Интересы"
            ) {
                ChipsGroup(
                    data = allChipsList,
                    size = ChipsSize.NORMAL,
                    selectedList = selectedChips,
                    onChangeSelect = onSelectChip,
                )
            }
        }

        if (allSocialMedia.isNotEmpty()) {
            item {
                LabeledCard(
                    label = "Социальные сети"
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
    }
}