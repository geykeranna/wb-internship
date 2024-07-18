package ru.testtask.testapplication.ui.component.toolbars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.testtask.testapplication.R
import ru.testtask.testapplication.presentation.data.model.UserData
import ru.testtask.testapplication.ui.component.utils.Constants.CONTENT_PADDING_IN_MENU_ITEM
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_MENU_ITEM
import ru.testtask.testapplication.ui.component.utils.Constants.ICON_SIZE_IN_MENU_ITEM
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.NeutralLineColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1

@Composable
fun MenuItem (
    modifier: Modifier = Modifier,
    iconRight: Int? = null,
    iconLeft: Int? = null,
    text: String = "",
    onClickItem: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(HEIGHT_MENU_ITEM.dp)
            .clickable { onClickItem() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_IN_MENU_ITEM.dp)
        ){
            iconLeft?.let {
                Icon(
                    modifier = Modifier
                        .size(ICON_SIZE_IN_MENU_ITEM.dp),
                    contentDescription = null,
                    painter = painterResource(it)
                )
            }
            Text (
                text = text,
                style = MaterialTheme.typography.bodyText1
            )
        }
        iconRight?.let {
            Icon(
                modifier = Modifier
                    .size(ICON_SIZE_IN_MENU_ITEM.dp),
                contentDescription = "next",
                painter = painterResource(it)
            )
        }
    }
}

@Composable
fun MenuItemUser(
    modifier: Modifier = Modifier,
    userData: UserData,
    iconRight: Int? = null,
    onClickItem: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(66.dp)
            .clickable { onClickItem() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            val mod = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(NeutralLineColor)

            if(userData.icon.isNullOrEmpty()) {
                Image(
                    modifier = mod
                        .padding(12.dp),
                    painter = painterResource(R.drawable.ic_user),
                    contentDescription = "avatar"
                )
            } else {
                AsyncImage(
                    modifier = mod,
                    model = userData.icon,
                    contentDescription = "avatar"
                )
            }
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text (
                    text = userData.name,
                    style = MaterialTheme.typography.bodyText1
                )
                Text (
                    text = userData.phone,
                    style = MaterialTheme.typography.metadata1,
                    color = NeutralDisabledColor
                )
            }
        }
        iconRight?.let {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                contentDescription = "next",
                painter = painterResource(it)
            )
        }
    }
}