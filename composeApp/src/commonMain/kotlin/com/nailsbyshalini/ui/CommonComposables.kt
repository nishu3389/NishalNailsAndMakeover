package com.nailsbyshalini.ui

import AppFontWeight
import DecorativeFontFamily
import PoppinsFontFamily
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    fontColor : Color = Colors.TextPrimary,
    extraLineHeight: Boolean = false,
    maxLines: Int = 7,
    weight: AppFontWeight = AppFontWeight.Regular,
    style: TextStyle = TextStyle.Default,
    textAlign: TextAlign = TextAlign.Center
) {
    val resolvedLineHeight = if(extraLineHeight) (fontSize * 2f) else (fontSize * 1.5f)

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(
            fontFamily = PoppinsFontFamily(),
            lineHeight = resolvedLineHeight,
            fontWeight = when (weight) {
                AppFontWeight.Light -> FontWeight.Light
                AppFontWeight.Regular -> FontWeight.Normal
                AppFontWeight.Medium -> FontWeight.Medium
                AppFontWeight.SemiBold -> FontWeight.SemiBold
                AppFontWeight.Bold -> FontWeight.Bold
                AppFontWeight.Decorative -> FontWeight.Bold
            },
            fontSize = fontSize,
            color = fontColor,
            textAlign = textAlign
        )
    )
}

@Composable
fun AppTextDecorative(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    fontColor : Color = Color.Black,
    weight: AppFontWeight = AppFontWeight.Regular,
    style: TextStyle = TextStyle.Default,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        style = TextStyle(
            fontFamily = DecorativeFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
            color = fontColor
        )
    )
}

@Composable
fun BeautyTagline(
    text: String,
    modifier: Modifier = Modifier
) {
    var revealed by remember { mutableStateOf(false) }

    // Reveal animation
    val revealProgress by animateFloatAsState(
        targetValue = if (revealed) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3500,
            easing = FastOutSlowInEasing
        ),
        label = "reveal"
    )

    // Floating animation (after reveal)
    val floatOffset by animateDpAsState(
        targetValue = if (revealed) (-3).dp else 0.dp,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float"
    )

    LaunchedEffect(Unit) {
        revealed = true
    }

    Box(
        modifier = modifier
            .offset(y = floatOffset)
            .clipToBounds()
    ) {
        // Mask layer (brush reveal)
        Box(
            modifier = Modifier
                .fillMaxWidth(revealProgress)
                .clip(RectangleShape)
        ) {
            TaglineText(text)
        }
    }
}

@Composable
fun TaglineText(text: String) {
    val accentColor = Color(0xFFFE6A6C)

    AppTextDecorative(text = "Shalini Nails & Makeover", weight = AppFontWeight.SemiBold, fontSize = 37.sp)

    Text(
        buildAnnotatedString {
            text.split(" ").forEach {
                if (it.contains("Glam", true)) {
                    withStyle(
                        SpanStyle(
                            color = accentColor,
                            shadow = Shadow(
                                color = accentColor.copy(alpha = 0.6f),
                                blurRadius = 20f
                            )
                        )
                    ) {
                        append("$it ")
                    }
                } else {
                    append("$it ")
                }
            }
        },
        fontSize = 37.sp,
        fontFamily = DecorativeFontFamily(),
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.5.sp,
        color = Color(0xFF2B2B2B)
    )
}
