package io.github.hyuck9.progressitem

import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    percent: Float = 0f,
    onClick: () -> Unit = {  },
    content: @Composable () -> Unit
) {
    ProgressItem(
        modifier = modifier,
        progressModifier = Modifier.background(brush, shape, alpha),
        percent = percent,
        onClick = onClick,
        content = content
    )
}

@Composable
fun ProgressItem(
    modifier: Modifier = Modifier,
    color: Color,
    shape: Shape = RectangleShape,
    percent: Float = 0f,
    onClick: () -> Unit = {  },
    content: @Composable () -> Unit
) {
    ProgressItem(
        modifier = modifier,
        progressModifier = Modifier.background(color, shape),
        percent = percent,
        onClick = onClick,
        content = content
    )
}

@Composable
fun ProgressItem(
    modifier: Modifier = Modifier,
    progressModifier: Modifier = Modifier,
    percent: Float = 0f,
    onClick: () -> Unit = {  },
    content: @Composable () -> Unit
) {
    BoxWithConstraints(
        modifier = modifier
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        val progressWidth = animateDpAsState(
            targetValue = maxWidth * percent / 100,
            animationSpec = tween(easing = EaseOutQuad)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = progressModifier
                    .width(width = progressWidth.value)
                    .fillMaxHeight()
            )
            content()
        }
    }
}