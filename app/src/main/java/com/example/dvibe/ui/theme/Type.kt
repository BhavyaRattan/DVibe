package com.example.dvibe.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dvibe.R

private val Cabin = FontFamily(
    Font(R.font.cabin_regular),
    Font(R.font.cabin_medium, FontWeight.W500),
    Font(R.font.cabin_bold, FontWeight.W600)
)

private val Raleway = FontFamily(
    fonts = listOf(
        Font(R.font.raleway_bold),
        Font(R.font.raleway_extra_bold, FontWeight.Bold)
    )
)

val DVibeTypography = Typography(
    defaultFontFamily = Cabin,
    h5 = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)