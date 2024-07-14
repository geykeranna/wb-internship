package ru.testtask.testapplication.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.avatars.ProfileAvatar
import ru.testtask.testapplication.ui.component.avatars.ProfileSize
import ru.testtask.testapplication.ui.component.chips.SocialChips
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_CHIPS_GROUP_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_AVATAR_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_TEXT_BLOCK_PROFILE_SCREEN
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.heading3
import ru.testtask.testapplication.ui.theme.subheading2

@Composable
fun ProfileViewScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val userData: UserData = UserData.shimmerData

    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED)
                navController.popBackStack()
        },
        iconRight = R.drawable.ic_edit,
        onRightIconClick = { },
        text = Screen.ProfileView.name
    )

    LazyColumn (
        modifier = Modifier
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            ProfileAvatar(
                modifier = Modifier.padding(top = VERTICAL_PADDING_AVATAR_PROFILE_SCREEN.dp),
                size = ProfileSize.LARGE
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = VERTICAL_PADDING_TEXT_BLOCK_PROFILE_SCREEN.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier,
                    text = userData.name,
                    style = MaterialTheme.typography.heading3.copy(textAlign = TextAlign.Center)
                )
                Text(
                    modifier = Modifier,
                    text = userData.phone,
                    style = MaterialTheme.typography.subheading2.copy(textAlign = TextAlign.Center),
                    color = NeutralDisabledColor
                )
            }

            SocialChips(
                modifier = Modifier.padding(PADDING_CHIPS_GROUP_PROFILE_SCREEN.dp),
                list = userData.socialMedia
            )
        }
    }
}