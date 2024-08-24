package ru.wb.ui.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

object AppTypo {
    val heading1 = TextStyle(
        fontSize = 34.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold
    )
    val heading2 = TextStyle(
        fontSize = 24.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )
    val heading3 = TextStyle(
        fontSize = 18.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )
    val subheading1 = TextStyle(
        fontSize = 24.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

    val subheading2 = TextStyle(
        fontSize = 16.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

    val subheading3 = TextStyle(
        fontSize = 14.sp,
        fontFamily = latoFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

    val bodyText1 = TextStyle(
        fontSize = 14.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold,
    )
    val bodyText2 = TextStyle(
        fontSize = 14.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal
    )
    val metadata1 = TextStyle(
        fontSize = 12.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal
    )
    val metadata2 = TextStyle(
        fontSize = 10.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal
    )
    val metadata3 = TextStyle(
        fontSize = 14.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.SemiBold
    )

    val primary = TextStyle(
        fontSize = 18.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
    )

    val secondary = TextStyle(
        fontSize = 14.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
    )

    val secondary1 = TextStyle(
        fontSize = 14.sp,
        fontFamily = interFamily,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
    )

    val textForTabs = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = TextUnit(0.83F, TextUnitType.Sp)
    )
    val usernameText = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    )
    val usernamePhoneNumber = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
    val chips = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
    )

    val communityLabel = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    )

    val communityLabelFull = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
    )

    val userPlusInList = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    )
}