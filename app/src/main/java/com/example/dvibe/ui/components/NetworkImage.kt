package com.example.dvibe.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.husseinala.neon.core.Neon
import com.husseinala.neon.core.Transformation
import com.husseinala.neon.core.circleCrop

@Composable
fun NetworkImage(
    url: String,
    size: Dp,
    modifier: Modifier = Modifier,
    transformation: Transformation = Transformation.circleCrop()
) {
    Neon(
        url = url,
        transformation = transformation,
        modifier = modifier.size(size),
        onLoading = {
            Box(modifier = modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = modifier.size(size)
                        .align(Alignment.Center),
                    color = MaterialTheme.colors.primary,
                    strokeWidth = 2.dp
                )
            }
        }
    )
}