package com.landomen.composemultiplatform.coil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nailsbyshalini.workImages
import composemultiplatformcoilsample.composeapp.generated.resources.Res
import composemultiplatformcoilsample.composeapp.generated.resources.back
import composemultiplatformcoilsample.composeapp.generated.resources.cross
import composemultiplatformcoilsample.composeapp.generated.resources.next
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            com.nailsbyshalini.App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val images = remember { workImages() }

    FullScreenOverlayCarousel(
        images = images,
        startIndex = 0,
        onClose = {
            println("closed")
        }
    )
}

@Composable
fun FullScreenOverlayCarousel(
    images: List<DrawableResource>,
    startIndex: Int,
    onClose: () -> Unit
) {
    var currentIndex by remember { mutableIntStateOf(startIndex) }
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xCC000000))
    ) {

        // 🖼️ IMAGE AREA (click left/right to navigate)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .pointerInput(currentIndex) {
                    detectTapGestures { offset ->
                        val width = size.width

                        if (offset.x < width / 2) {
                            // ⬅️ LEFT HALF
                            if (currentIndex > 0) currentIndex--
                        } else {
                            // ➡️ RIGHT HALF
                            if (currentIndex < images.lastIndex) currentIndex++
                        }
                    }
                }
        ) {
            Image(
                painter = painterResource(images[currentIndex]),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        // ⬅️ PREVIOUS ARROW (optional visual hint)
        if (currentIndex > 0) {
            ArrowButton(
                Res.drawable.back,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                currentIndex--
            }
        }

        // ➡️ NEXT ARROW (optional visual hint)
        if (currentIndex < images.lastIndex) {
            ArrowButton(
                Res.drawable.next,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                currentIndex++
            }
        }

        // ❌ CLOSE BUTTON
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp)
                .size(60.dp)
                .hoverable(interactionSource)
                .clickable { onClose() },
            contentAlignment = Alignment.Center
        ) {
            if (isHovered) {
                Box(
                    Modifier
                        .size(60.dp)
                        .background(Color(0x80FFFFFF), RoundedCornerShape(6.dp))
                )
            }
            Image(
                painter = painterResource(Res.drawable.cross),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
fun ArrowButton(
    image: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        Spacer(Modifier.width(20.dp).align(Alignment.CenterVertically))

        Box(
            modifier = modifier
                .size(40.dp)
                .background(Color.White, CircleShape)
                .clickable { onClick() }.align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(Modifier.width(20.dp).align(Alignment.CenterVertically))

    }

}

