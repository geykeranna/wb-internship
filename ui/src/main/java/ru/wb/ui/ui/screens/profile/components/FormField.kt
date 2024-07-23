package ru.wb.ui.ui.screens.profile.components

import androidx.compose.runtime.MutableState

data class FormField (
    val id: Int,
    val name: String,
    val placeholder: String,
    val required: Boolean,
    val inputValue: MutableState<String>
)
