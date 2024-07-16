package ru.testtask.testapplication.ui.screens.profile.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

@OptIn(ExperimentalFoundationApi::class)
data class FormField (
    val id: Int,
    val name: String,
    val placeholder: String,
    val required: Boolean,
    val value: TextFieldState
)
