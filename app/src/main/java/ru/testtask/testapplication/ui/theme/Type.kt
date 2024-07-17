package ru.testtask.testapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography()

val Typography.heading1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 32.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold
    )

val Typography.heading2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 24.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold
    )

val Typography.heading3: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 24.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

val Typography.subheading1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 18.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

val Typography.subheading2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 16.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

val Typography.subheading3: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 14.sp,
        fontFamily = latoFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

val Typography.bodyText1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 14.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold,
    )

val Typography.bodyText2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 14.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal
    )

val Typography.metadata1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 12.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal
    )

val Typography.metadata2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 10.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal
    )

val Typography.metadata3: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 10.sp,
        fontFamily = sfProDisplayFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )