package io.moiro.vision.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.moiro.vision.R

private val HelveticaNeue = FontFamily(
    Font(R.font.helveticaneuemedium),
    Font(R.font.helveticaneuebold, FontWeight.Bold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = HelveticaNeue,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)