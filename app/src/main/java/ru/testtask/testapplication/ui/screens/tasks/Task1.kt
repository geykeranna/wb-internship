package ru.testtask.testapplication.ui.screens.tasks

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.avatars.GroupAvatar
import ru.testtask.testapplication.ui.component.avatars.ProfileAvatar
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.button.default.CustomButton
import ru.testtask.testapplication.ui.component.button.outlined.AnimatedCustomOutlinedButton
import ru.testtask.testapplication.ui.component.button.outlined.CustomOutlinedButton
import ru.testtask.testapplication.ui.component.button.text.AnimatedCustomTextButton
import ru.testtask.testapplication.ui.component.button.text.CustomTextButton
import ru.testtask.testapplication.ui.component.chips.CustomChipsGroup
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.bodyText2
import ru.testtask.testapplication.ui.theme.heading1
import ru.testtask.testapplication.ui.theme.heading2
import ru.testtask.testapplication.ui.theme.metadata1
import ru.testtask.testapplication.ui.theme.metadata2
import ru.testtask.testapplication.ui.theme.metadata3
import ru.testtask.testapplication.ui.theme.subheading1
import ru.testtask.testapplication.ui.theme.subheading2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Task1() {
    val scroll = rememberScrollState()
    val modifier = Modifier.padding(vertical = 20.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(scroll)
    ) {
        Text(modifier = modifier, text = "Кнопки в разных статусах", style = MaterialTheme.typography.heading2)

        ButtonFrame()

        Text(modifier = modifier, text = "Текстовое поле ", style = MaterialTheme.typography.heading2)

        TextView()

        Text(modifier = modifier, text = "Аватар (обычный, встречи) ", style = MaterialTheme.typography.heading2)

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileAvatar(
                modifier = Modifier.padding(bottom = 10.dp)
            )

            GroupAvatar()
        }

        Text(modifier = modifier, text = "Строка поиска", style = MaterialTheme.typography.heading2)

        SearchBar(
            modifier = Modifier.padding(bottom = 20.dp),
            state = rememberTextFieldState("")
        )

        Text(modifier = modifier, text = "Чипсы", style = MaterialTheme.typography.heading2)

        CustomChipsGroup(
            modifier = Modifier.padding(bottom = 20.dp),
            chipsList = listOf("Python", "Junior", "Moscow")
        )
    }
}

@Composable
fun ButtonFrame() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(label = "Button")
            CustomButton(label = "Button", isPrimary = true)
            CustomButton(label = "Button", outlined = true)
            CustomButton(label = "Button", disabled = true)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomOutlinedButton(label = "Button")
            CustomOutlinedButton(label = "Button", isPrimary = true)
            CustomOutlinedButton(label = "Button", outlined = true)
            CustomOutlinedButton(label = "Button", disabled = true)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextButton(label = "Button")
            CustomTextButton(label = "Button", isPrimary = true)
            CustomTextButton(label = "Button", outlined = true)
            CustomTextButton(label = "Button", disabled = true)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedCustomButton(label = "Animated")
            AnimatedCustomButton(label = "Animated", disabled = true)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedCustomOutlinedButton(label = "Animated")
            AnimatedCustomOutlinedButton(label = "Animated", disabled = true)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedCustomTextButton(label = "Animated")
            AnimatedCustomTextButton(label = "Animated", disabled = true)
        }
    }
}

@Composable
fun TextView(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        val modifier = Modifier.padding(vertical = 10.dp)
        Text(
            modifier = modifier,
            text = "Typography",
            style = MaterialTheme.typography.heading1
        )

        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.heading1
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.heading2
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.subheading1
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.subheading2
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.bodyText1
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.bodyText2
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.metadata1
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.metadata2
        )
        Text(
            modifier = modifier,
            text = "The quick brown fox jumps over the lazy dog",
            style = MaterialTheme.typography.metadata3
        )
    }
}