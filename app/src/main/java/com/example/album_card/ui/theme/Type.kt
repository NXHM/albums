package com.example.album_card.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
// Set of Material typography styles to start with
val titleAlbum = TextStyle(
        fontFamily = FontFamily.SansSerif, // Cambia esto a la fuente que prefieras
        fontWeight = FontWeight.Bold, // Cambia esto al peso que prefieras
        fontSize = 17.sp, // Cambia esto al tamaño que prefieras
        lineHeight = 13.sp, // Cambia esto a la altura de línea que prefieras
        letterSpacing = 0.15.sp // Cambia esto al espaciado de letras que prefieras
)
val descriptionAlbum = TextStyle(
        fontFamily = FontFamily.SansSerif, // Cambia esto a la fuente que prefieras
        fontWeight = FontWeight.Normal, // Cambia esto al peso que prefieras
        fontSize = 10.sp, // Cambia esto al tamaño que prefieras
        lineHeight = 7.sp, // Cambia esto a la altura de línea que prefieras
        letterSpacing = 0.10.sp // Cambia esto al espaciado de letras que prefieras
)
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        )
        /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)