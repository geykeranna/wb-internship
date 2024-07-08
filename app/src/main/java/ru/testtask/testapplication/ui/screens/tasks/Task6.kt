package ru.testtask.testapplication.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.input.InputNumberField
import ru.testtask.testapplication.ui.component.input.InputPassField

@Composable
fun Task6() {
    Column(
        modifier = Modifier
    ) {
        val mod = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 60.dp)

        InputNumberField(
            modifier = mod
        )

        InputPassField(
            modifier = mod
        )
    }
}