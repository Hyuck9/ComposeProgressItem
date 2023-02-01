package io.github.hyuck9.progressitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Composable
fun ProgressItem(
    modifier: Modifier = Modifier,
    brush: Brush,
    shape: Shape = RectangleShape,
    alpha: Float = 1.0f,
    percent: Float,
    content: @Composable () -> Unit
) {
    ProgressItem(
        modifier = modifier,
        progressModifier = Modifier.background(brush, shape, alpha),
        percent = percent,
        content = content
    )
}

@Composable
fun ProgressItem(
    modifier: Modifier = Modifier,
    color: Color,
    shape: Shape = RectangleShape,
    percent: Float,
    content: @Composable () -> Unit
) {
    ProgressItem(
        modifier = modifier,
        progressModifier = Modifier.background(color, shape),
        percent = percent,
        content = content
    )
}

@Composable
fun ProgressItem(
    modifier: Modifier = Modifier,
    progressModifier: Modifier = Modifier,
    percent: Float,
    content: @Composable () -> Unit
) {
    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        val progressWidth = (maxWidth * percent / 100)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = progressModifier
                    .width(width = progressWidth)
                    .fillMaxHeight()
            )
            content()
        }
    }
}