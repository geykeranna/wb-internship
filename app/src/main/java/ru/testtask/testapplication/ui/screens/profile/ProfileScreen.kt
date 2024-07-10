package ru.testtask.testapplication.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.avatars.ProfileAvatar
import ru.testtask.testapplication.ui.component.avatars.ProfileSize
import ru.testtask.testapplication.ui.component.chips.SocialChips
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.heading3
import ru.testtask.testapplication.ui.theme.subheading2

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
){
    val scroll = rememberScrollState()
    val userData: UserData = UserData.shimmerData

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            modifier = modifier.padding(horizontal = 16.dp),
            iconLeft = R.drawable.ic_chevron_left,
            onLeftIconClick = {  },
            iconRight = R.drawable.ic_edit,
            onRightIconClick = { },
            text = "Профиль"
        )

        Column (
            modifier = Modifier
                .verticalScroll(scroll),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ProfileAvatar(
                modifier = Modifier.padding(top = 50.dp),
                size = ProfileSize.LARGE
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
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
                modifier = Modifier.padding(26.dp),
                list = userData.socialMedia
            )
        }
    }
}