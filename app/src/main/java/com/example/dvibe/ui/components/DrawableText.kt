package com.example.dvibe.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DrawableText(
    drawableStart: ImageVector? = null,
    drawableEnd: ImageVector? = null,
    drawablePadding: Dp = 0.dp,
    tint: Color = MaterialTheme.colors.secondary,
    text: String,
    style: TextStyle = MaterialTheme.typography.body2
        .copy(color = MaterialTheme.colors.primary),
    modifier: Modifier
) {
    Row(modifier = modifier.wrapContentWidth(), verticalAlignment = Alignment.CenterVertically) {
        if (drawableStart != null) {
            Icon(
                imageVector = drawableStart,
                modifier = modifier,
                tint = tint,
                contentDescription = null
            )
        }

        Text(modifier = modifier, text = text, style = style)

        if (drawableEnd != null) {
            Spacer(modifier.width(drawablePadding))
            Icon(
                imageVector = drawableEnd,
                modifier = modifier,
                tint = tint,
                contentDescription = null
            )
        }
    }
}