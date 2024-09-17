package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ProfileView(
    userData: UserData,
    eventData: List<EventData>,
    communityData: List<CommunityData>,
    state: BaseState,
    formField: ProfileFormState,
    allChipsList: List<String>,
    socialMedia: List<SocialMedia>,
    modifier: Modifier = Modifier,
    selectedChips: List<String> = listOf(),
    pageMode: ProfilePageMode = ProfilePageMode.VIEW_OUTSIDE,
    onBackNavigate: () -> Unit = {},
    onBottomClick: () -> Unit = {},
    onSelectChip: (newValue: String) -> Unit = {},
    onPageModeChange: (newPageMode: ProfilePageMode) -> Unit = {},
    onValueChange: (key: Int, value: Any) -> Unit = {_, _ -> },
){
    Scaffold(
        modifier = modifier,
        containerColor = AppTheme.colors.neutralColorBackground,
        topBar = {
            TopBarWithAvatar(
                modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
                src = userData.icon,
                pageMode = pageMode,
                onNavigate = onBackNavigate,
                onPageModeChange = onPageModeChange,
            )
        },
    ) { padding ->
        BaseScreen(
            modifier = modifier.padding(padding),
            state = state
        ) {
            when (pageMode){
                ProfilePageMode.EDIT -> {
                    ProfileEditCard(
                        modifier = modifier,
                        formField = formField,
                        onValueChange = onValueChange,
                        allChipsList = allChipsList,
                        selectedChips = selectedChips,
                        onSelectChip = onSelectChip,
                        allSocialMedia = socialMedia,
                    )
                }
                else -> {
                    ProfileViewCard(
                        modifier = modifier,
                        userData = userData,
                        communityData = communityData,
                        eventData = eventData,
                        pageMode = pageMode,
                        onBottomClick = onBottomClick,
                    )
                }
            }
        }
    }
}