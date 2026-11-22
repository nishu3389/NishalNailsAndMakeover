package com.nailsbyshalini

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nishalnailsandmakeover.composeapp.generated.resources.Res
import nishalnailsandmakeover.composeapp.generated.resources.back
import nishalnailsandmakeover.composeapp.generated.resources.cross
import nishalnailsandmakeover.composeapp.generated.resources.next
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArrowButton(
    image: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .background(Color.White, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }

}

@Composable
fun ZoomableImage(
    image: DrawableResource,
    modifier: Modifier = Modifier
) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    val transformState = rememberTransformableState { zoomChange, panChange, _ ->
        scale = (scale * zoomChange).coerceIn(1f, 4f)
        offset += panChange
    }

    Box(
        modifier = modifier
            .transformable(transformState)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                translationX = offset.x
                translationY = offset.y
            }
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ImageIndicator(
    currentIndex: Int,
    total: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = "${currentIndex + 1} / $total",
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun FullScreenOverlayCarousel(
    images: List<DrawableResource>,
    startIndex: Int,
    onClose: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    var currentIndex by remember { mutableStateOf(startIndex) }
    var direction by remember { mutableStateOf(1) }

    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xCC000000))
            .focusRequester(focusRequester)
            .focusable()                // 🔑 required
            .onKeyEvent { event ->      // 🔑 USE THIS (not preview)
                if (event.type != KeyEventType.KeyDown) return@onKeyEvent false

                when (event.key) {
                    Key.DirectionLeft -> {
                        if (currentIndex > 0) {
                            direction = -1
                            currentIndex--
                        }
                        true
                    }

                    Key.DirectionRight -> {
                        if (currentIndex < images.lastIndex) {
                            direction = 1
                            currentIndex++
                        }
                        true
                    }

                    Key.Escape -> {
                        onClose()
                        true
                    }

                    else -> false
                }
            }
    ) {

        // 🔑 REQUEST FOCUS WHEN OVERLAY OPENS
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

        // 🎞 Animated + zoomable image
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(currentIndex) {
                    detectTapGestures { offset ->
                        if (offset.x < size.width / 2) {
                            if (currentIndex > 0) {
                                direction = -1
                                currentIndex--
                            }
                        } else {
                            if (currentIndex < images.lastIndex) {
                                direction = 1
                                currentIndex++
                            }
                        }
                    }
                }
        ) {
            AnimatedContent(
                targetState = images[currentIndex],
                transitionSpec = {
                    if (direction > 0) {
                        slideInHorizontally { it } togetherWith slideOutHorizontally { -it }
                    } else {
                        slideInHorizontally { -it } togetherWith slideOutHorizontally { it }
                    }
                }
            ) { img ->
                ZoomableImage(
                    image = img,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // ⬅️ ➡️ Arrows (unchanged)
        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (currentIndex > 0) {
                ArrowButton(Res.drawable.back) {
                    direction = -1
                    currentIndex--
                }
            } else Spacer(Modifier.size(50.dp))

            if (currentIndex < images.lastIndex) {
                ArrowButton(Res.drawable.next) {
                    direction = 1
                    currentIndex++
                }
            } else Spacer(Modifier.size(50.dp))
        }

        // 📍 Indicator
        ImageIndicator(
            currentIndex = currentIndex,
            total = images.size,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )

        // ❌ CLOSE
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp)
                .size(50.dp)
                .hoverable(interactionSource)
                .clickable { onClose() },
            contentAlignment = Alignment.Center
        ) {
            if (isHovered) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color(0x80FFFFFF), RoundedCornerShape(6.dp))
                )
            }
            Image(
                painter = painterResource(Res.drawable.cross),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
