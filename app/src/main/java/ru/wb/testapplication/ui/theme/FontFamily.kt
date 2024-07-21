package ru.wb.testapplication.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import ru.wb.testapplication.R

val sfProDisplayFamily = FontFamily(
    Font(R.font.sf_pro_display_light, FontWeight.Light),
    Font(R.font.sf_pro_display_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_regular_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.sf_pro_display_black, FontWeight.Black),
    Font(R.font.sf_pro_display_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.sf_pro_display_thin, FontWeight.Thin),
    Font(R.font.sf_pro_display_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
)

val latoFamily = FontFamily(
    Font(R.font.lato_semibold, FontWeight.SemiBold)
)