package com.example.dvibe.ui.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.contentColor
import androidx.compose.foundation.currentTextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DrawableText(
    drawableStart: VectorAsset? = null,
    drawableEnd: VectorAsset? = null,
    drawablePadding: Dp = 0.dp,
    tint: Color = MaterialTheme.colors.secondary,
    text: String,
    style: TextStyle = MaterialTheme.typography.body2
        .copy(color = MaterialTheme.colors.primary),
    modifier: Modifier
) {
    Row(modifier = modifier.wrapContentWidth(), verticalAlignment = Alignment.CenterVertically) {
        if (drawableStart != null) {
            Icon(asset = drawableStart, modifier = modifier, tint = tint)
            Spacer(modifier.preferredWidth(drawablePadding))
        }

        Text(modifier = modifier, text = text, style = style)

        if (drawableEnd != null) {
            Spacer(modifier.preferredWidth(drawablePadding))
            Icon(asset = drawableEnd, modifier = modifier, tint = tint)
        }
    }
}